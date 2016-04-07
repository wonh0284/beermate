/**
 * 
 */
package com.beermate.config;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

import com.heroku.sdk.jdbc.DatabaseUrl;

/**
 * @author wonho
 *
 */
@Configuration
public class DatabaseConfig {

	/**
	 * @return
	 * @throws SQLException
	 * @throws URISyntaxException
	 */
	public static Connection getConnection() throws SQLException, URISyntaxException {
		return DatabaseUrl.extract().getConnection();
		//return DataSourceBuilder.create().build();
	}
}
