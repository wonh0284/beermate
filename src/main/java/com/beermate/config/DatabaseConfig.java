/**
 * 
 */
package com.beermate.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Configuration;

/**
 * @author wonho
 *
 */
@Configuration
public class DatabaseConfig {

	/**
	 * 
	 * @return
	 */
	public BasicDataSource dataSource() {
		
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl("");
		ds.setUsername("");
		ds.setPassword("");
		ds.setDriverClassName("");
		ds.setInitialSize(1);
		
		return ds;
	}
}
