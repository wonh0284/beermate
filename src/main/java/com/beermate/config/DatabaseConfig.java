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
		ds.setUrl("jdbc:postgresql://ec2-54-243-243-89.compute-1.amazonaws.com:5432/dbaap0n80c9lji");
		ds.setUsername("udptwequdoardc");
		ds.setPassword("lGDwKQBxBR7vd3w00Vdj7X-XEs");
		ds.setDriverClassName("org.postgresql.Driver");
		ds.addConnectionProperty("ssl", "true");
		ds.addConnectionProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");
		ds.setInitialSize(1);

		return ds;
	}
}
