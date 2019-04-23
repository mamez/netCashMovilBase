package com.bbva.pibee.config.cbd;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("dev")
public class Btlclco1DevelopmentProfileConfig {	
	
	private static Logger logger = Logger.getLogger("pibee");
	
	@Autowired
	Environment env;
	
	@Bean(name="BTLCLCO1")
	public DataSource dataSource(){
		try {
			 DriverManagerDataSource dataSource = new DriverManagerDataSource();
		     dataSource.setDriverClassName(env.getRequiredProperty("pibee.jdbc.driver"));
		     dataSource.setUrl(env.getRequiredProperty("pibee.btlclco1.url"));
		     dataSource.setUsername(env.getRequiredProperty("pibee.btlclco1.username"));
		     dataSource.setPassword(env.getRequiredProperty("pibee.btlclco1.password"));
		     logger.debug("Iniciando conecxion base de datos ID: BTLCLCO1");
		     logger.debug("URL :"+dataSource.getConnection().getMetaData().getURL());
			 logger.debug("Usuario :"+dataSource.getConnection().getMetaData().getUserName());
		     return  (DataSource)dataSource;
		}catch (Exception e) {
			logger.debug("Error al instanciar la base de datos "+e.getMessage());
			return null;
		}
		
	}
	
	
	
	@Bean(name="BTLCLCO1namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	 @Bean(name="TXBTLCLCO1")
	    public PlatformTransactionManager txManager() {
	        return new DataSourceTransactionManager(dataSource());
	    }
	
		
}
