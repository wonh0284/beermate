/**
 * 
 */
package com.beermate.config;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
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
	 * @throws URISyntaxException 
	 */
	@Bean
	public BasicDataSource dataSource() throws URISyntaxException {
		
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(dbUrl);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
        basicDataSource.setDriverClassName("org.postgresql.Driver");
        basicDataSource.addConnectionProperty("ssl", "true");
        basicDataSource.addConnectionProperty("sslfactory", "org.postgresql.ssl.NonValidatingFactory");

        return basicDataSource;
	}
}
