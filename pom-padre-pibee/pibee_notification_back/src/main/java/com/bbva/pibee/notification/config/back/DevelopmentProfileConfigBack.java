package com.bbva.pibee.notification.config.back;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;

import com.bbva.pibee.aso.noti.config.DevelopmentProfileConfigAsoNoti;
import com.bbva.pibee.aso.noti.config.ProductionProfileConfigAsoNoti;
import com.bbva.pibee.config.cbd.DevelopmentNotiProfileConfigCbd;
import com.bbva.pibee.rest.util.EncryptAes;

@Configuration
@ComponentScan(basePackages={"com.bbva.pibee.notification.back"})
@Import({DevelopmentNotiProfileConfigCbd.class,DevelopmentProfileConfigAsoNoti.class})
@Profile("dev-noti")
public class DevelopmentProfileConfigBack {
	
	@Bean
	public EncryptAes EncryptAes() {
		return new EncryptAes(); 
	} 
}

