package com.bbva.pibee.cbd.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bbva.pibee.context.RequestInterceptor;

@Configuration
public class ConfigContext {
     
	@Bean
	public RequestInterceptor requestInterceptor(){
		RequestInterceptor req= new RequestInterceptor();
		req.setUserId("ANDRESPI");
		req.setReference("002600824000300");
		return req;
	}
	
}
