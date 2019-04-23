package com.bbva.pibee.aso.noti.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.aso.noti"})
@ImportResource("classpath:/spring-config-noti.xml")
@Profile("prod-noti")
public class ProductionProfileConfigAsoNoti {

	
}
