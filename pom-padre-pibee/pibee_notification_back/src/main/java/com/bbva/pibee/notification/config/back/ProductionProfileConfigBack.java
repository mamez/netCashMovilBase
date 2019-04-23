package com.bbva.pibee.notification.config.back;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
//import org.springframework.context.annotation.PropertySource;

import com.bbva.pibee.config.cbd.ProductionNotiProfileConfigCbd;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.notification.back"})
@Import({ProductionNotiProfileConfigCbd.class})
@Profile("prod-noti")
public class ProductionProfileConfigBack {
	
	@Bean
	public InitContext initContext(){
		return new InitContext(); 
	}
}
