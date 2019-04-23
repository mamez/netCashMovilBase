package com.bbva.pibee.util;

public enum CodeLanguage {
	ES(1),
	EN(2);
	
    private int codeLanguage;
	
	private CodeLanguage(int codeLanguage){
		this.codeLanguage = codeLanguage;
	}
	
	public int getCodeLanguage(){
		return this.codeLanguage;
	}
}
