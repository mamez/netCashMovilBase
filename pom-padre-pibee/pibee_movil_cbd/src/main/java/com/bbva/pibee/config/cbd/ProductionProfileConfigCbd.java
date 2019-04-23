package com.bbva.pibee.config.cbd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:configCbd.properties")
@ComponentScan(basePackages={"com.bbva.pibee.cbd"})
@Import({Btlclco1ProductionProfileConfig.class, Btlneco1ProductionProfileConfig.class})
@Profile("prod")
public class ProductionProfileConfigCbd {
	
	

}
