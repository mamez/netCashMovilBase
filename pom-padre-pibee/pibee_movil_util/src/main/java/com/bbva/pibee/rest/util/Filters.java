package com.bbva.pibee.rest.util;

import java.util.List;

import com.bbva.pibee.rest.exception.BbvaFilterListException;
import com.bbva.pibee.rest.exception.FilterListExceptionType;

public class Filters<T> {
	
	private List<T> listResponse;
	private int paginationKey;
	private int pageSize;
    
	@SuppressWarnings("unchecked")
	public void  FiltersList(List<T> lista, int paginationKey, int pageSize) throws BbvaFilterListException{
		double paginacionTotal=0;
		int limInf=0;
		int limSup=0;
		int listSize=0;
		//validacion de tamaño de lista, paginationKey, pageSize
		if(lista.isEmpty()||paginationKey<=0||pageSize<=0){
			if(lista.isEmpty()){
				throw new BbvaFilterListException(FilterListExceptionType.LIST_IS_EMPTY);
			}else if(paginationKey==0){
				throw new BbvaFilterListException(FilterListExceptionType.PAGINATION_KEY_CERO);
			}else if(pageSize==0){
				throw new BbvaFilterListException(FilterListExceptionType.PAGINATION_SIZE_CERO);
			}
		}else{
			try {
				listSize=lista.size();
				this.listResponse=lista.getClass().newInstance();
				//determino limites
					limInf=(paginationKey-1)*pageSize;
					limSup=limInf+(pageSize-1);
					for(int i=limInf;i<=limSup;i++){
						if(listSize > i){
							listResponse.add( lista.get(i));
						}else{
							break;
						}
					}
					//calculamos  paginationKey y pageSize
					int nextPages=(listSize-1)-limSup;
					if(nextPages <= 0){
						this.paginationKey=paginationKey;
						this.pageSize=pageSize;
					}else{
						this.paginationKey=paginationKey+1;
						if(nextPages > pageSize){
							//this.pageSize=pageSize;
							this.pageSize=pageSize;
						}else{
							//this.pageSize=nextPages;
							this.pageSize=pageSize;
						}
					}
			} catch (IllegalAccessException e) {
				throw new BbvaFilterListException(FilterListExceptionType.GENERAL_ERROR);
			} catch (InstantiationException e) {
				throw new BbvaFilterListException(FilterListExceptionType.GENERAL_ERROR);
			}
			
		}
	}

	public List<T> getListResponse() {
		return listResponse;
	}

	public int getPaginationKey() {
		return paginationKey;
	}

	public int getPageSize() {
		return pageSize;
	} 
	
}
