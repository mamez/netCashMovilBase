package com.bbva.pibee.config.cbd;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.pm.cbd.notification"})
@PropertySource("classpath:configCbd.properties")
@Import({BncmcoDevelopmentProfileConfig.class })
@Profile("dev-noti")
public class DevelopmentNotiProfileConfigCbd {
	
	

}
