package com.bbva.pibee.pm.cbd.notification.dao;

import java.util.List;

import com.bbva.pibee.dto.cbd.prueba.TtlnemanDto;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;

public interface TtlnemanDao {
  public List<TtlnemanDto> getAllTtlneman()  throws BbvaClientCbdException;
  public TtlnemanDto  getTtlneman(String idOrden)  throws BbvaClientCbdException; 
  public void  deleteTtlneman(String idOrden)  throws BbvaClientCbdException; 
}
