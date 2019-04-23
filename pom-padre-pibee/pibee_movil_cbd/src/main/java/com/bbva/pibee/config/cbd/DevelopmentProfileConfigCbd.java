package com.bbva.pibee.config.cbd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.cbd"})
@PropertySource("classpath:configCbd.properties")
@Import({Btlclco1DevelopmentProfileConfig.class,Btlneco1DevelopmentProfileConfig.class})
@Profile("dev")
public class DevelopmentProfileConfigCbd {
	
	

}
