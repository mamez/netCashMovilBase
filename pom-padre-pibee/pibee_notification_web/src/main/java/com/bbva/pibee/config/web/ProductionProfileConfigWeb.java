package com.bbva.pibee.config.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.bbva.pibee.notification.config.back.ProductionProfileConfigBack;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.bbva.pibee.web","com.bbva.pibee.aop","com.bbva.pibee.context"})
@Import({ProductionProfileConfigBack.class})
@PropertySource("classpath:applicationsConfig.properties")
@Profile("prod-noti")
public class ProductionProfileConfigWeb {

	
	
}
