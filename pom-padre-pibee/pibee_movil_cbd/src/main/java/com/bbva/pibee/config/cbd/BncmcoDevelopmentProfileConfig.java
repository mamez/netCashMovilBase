package com.bbva.pibee.config.cbd;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("dev-noti")
public class BncmcoDevelopmentProfileConfig {
	@Autowired
	Environment env;
	
	@Bean(name="BNCMCO")
	public DataSource dataSource(){
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("pibee.jdbc.driver"));
	        dataSource.setUrl(env.getRequiredProperty("pibee.bncmco.url"));
	        dataSource.setUsername(env.getRequiredProperty("pibee.bncmco.username"));
	        dataSource.setPassword(env.getRequiredProperty("pibee.bncmco.password"));
	        return  (DataSource)dataSource;
	}
	
	
	@Bean(name="BNCMCOnamedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	
	 @Bean(name="TXBNCMCO")
	    public PlatformTransactionManager txManager() {
	        return new DataSourceTransactionManager(dataSource());
	    }
	
}
