package com.bbva.pibee.config.cbd;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@Profile("dev")
public class Btlneco1DevelopmentProfileConfig {
	
	private static Logger logger = Logger.getLogger("pibee");
	
	@Autowired
	Environment env;
	
	@Bean(name="BTLNECO1")
	public DataSource dataSource(){
		try {
		 DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(env.getRequiredProperty("pibee.jdbc.driver"));
	        dataSource.setUrl(env.getRequiredProperty("pibee.btlneco1.url"));
	        dataSource.setUsername(env.getRequiredProperty("pibee.btlneco1.username"));
	        dataSource.setPassword(env.getRequiredProperty("pibee.btlneco1.password"));
	        logger.debug("Iniciando conecxion base de datos ID: BTLNECO1");
	        logger.debug("URL :"+dataSource.getConnection().getMetaData().getURL());
			logger.debug("Usuario :"+dataSource.getConnection().getMetaData().getUserName());
		    return  (DataSource)dataSource;
		}catch (Exception e) {
			logger.debug("Error al instanciar la base de datos "+e.getMessage());
			return null;
		}
	}
	
	@Bean(name="BTLNECO1namedParameterJdbcTemplate")
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean(name="TXBTLNECO1")
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
}
