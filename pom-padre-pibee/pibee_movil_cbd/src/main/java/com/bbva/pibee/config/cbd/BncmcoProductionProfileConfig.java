package com.bbva.pibee.config.cbd;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Profile("prod-noti")
public class BncmcoProductionProfileConfig {
	
private static Logger logger = Logger.getLogger("pibee");
	
	@Autowired
	Environment env;
	
	@Bean(name ="BNCMCO")
	@Order(1)
	public DataSource dataSource(){
		try {
		final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup(); 
		dsLookup.setResourceRef(true); 
		DataSource dataSource = dsLookup.getDataSource(env.getRequiredProperty("pibee.bncmco.jdni")); 
		logger.debug("Estableciendo conexion "+env.getRequiredProperty("pibee.bncmco.jdni"));
		logger.debug("URL :"+dataSource.getConnection().getMetaData().getURL());
		logger.debug("Usuario :"+dataSource.getConnection().getMetaData().getUserName());
		return dataSource;
      }catch (Exception e) {
    	logger.debug("Error al instanciar la base de datos JDNI "+env.getRequiredProperty("pibee.bncmco.jdni"));
			logger.debug("Detalle "+e.getMessage());
			return null;
		}	
	}
	
	@Bean(name="BNCMCOnamedParameterJdbcTemplate")
	@Order(3)
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(dataSource());
	}
	
	@Bean(name="TXBNCMCO")
	@Order(2)
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
	

}
