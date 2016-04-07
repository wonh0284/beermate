package com.beermate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beermate.config.DatabaseConfig;

@SpringBootApplication
public class BeermateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeermateApplication.class, args);
	}
}

@RestController
class HomeRestController {
	
	@RequestMapping("/home")
	public Object home() throws SQLException {
		
		Connection conn = null;
		DataSource ds = new DatabaseConfig().dataSource();
		
		ArrayList<String> output = new ArrayList<String>();
		
		try {
			conn = ds.getConnection();
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
			stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
			ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

			while (rs.next()) {
				output.add("Read from DB: " + rs.getTimestamp("tick"));
			}
			
		} finally {
			if(conn != null) {
				conn.close();
			}
		}
		
		return output;
	}
}