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
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@EnableTransactionManagement
@Profile("prod")
public class Btlneco1ProductionProfileConfig {
	
	private static Logger logger = Logger.getLogger("pibee");
	
	@Autowired
	Environment env;
	
	@Bean(name="BTLNECO1")
	@Order(1)
	public DataSource dataSource(){
		try {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup(); 
		dsLookup.setResourceRef(true); 
		DataSource dataSource = dsLookup.getDataSource(env.getRequiredProperty("pibee.btlneco1.jdni")); 
		logger.debug("Estableciendo conexion "+env.getRequiredProperty("pibee.btlclco1.jdni"));
		logger.debug("URL :"+dataSource.getConnection().getMetaData().getURL());
		logger.debug("Usuario :"+dataSource.getConnection().getMetaData().getUserName());
		return dataSource;
      }catch (Exception e) {
    	logger.debug("Error al instanciar la base de datos JDNI "+env.getRequiredProperty("pibee.btlclco1.jdni"));
			logger.debug("Detalle "+e.getMessage());
			return null;
		}	
	}
	
	@Bean(name="BTLNECO1namedParameterJdbcTemplate")
	@Order(3)
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate()
	{
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean(name="TXBTLNECO1")
	@Order(2)
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
}
