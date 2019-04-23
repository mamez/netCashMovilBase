package com.bbva.pibee.arq.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbva.pibee.rest.exception.BbvaClientAsoException;
import com.bbva.pibee.rest.exception.BbvaClientBackException;
import com.bbva.pibee.rest.exception.BbvaClientCbdException;
import com.bbva.pibee.rest.exception.BbvaClientCwsException;

@Retention(RetentionPolicy.RUNTIME)
@Transactional(rollbackFor= {BbvaClientCbdException.class, BbvaClientBackException.class,BbvaClientCwsException.class,BbvaClientAsoException.class
		, Exception.class},value="TXBNCMCO",propagation = Propagation.REQUIRED)
public @interface TransactionalBncmco {

}
