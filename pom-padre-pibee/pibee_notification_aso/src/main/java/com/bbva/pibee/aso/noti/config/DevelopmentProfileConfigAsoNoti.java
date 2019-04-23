package com.bbva.pibee.aso.noti.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.aso.noti"})
@PropertySource("classpath:ClientASOconfigNoti.properties")
@ImportResource("classpath:/spring-config-noti.xml")
@Profile("dev-noti")
public class DevelopmentProfileConfigAsoNoti {

	
}
