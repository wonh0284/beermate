/**
 * 
 */
package com.beermate.web;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beermate.config.DatabaseConfig;
import com.beermate.dao.JdbcDao;

/**
 * @author wlee
 *
 */
@Controller
public class HomeController {

	@Autowired
	private JdbcDao jdbcDao;
	
	@RequestMapping("/home")
	public String home() throws SQLException {
		return "home";
	}
	
	@RequestMapping("/db")
	@ResponseBody
	public Object db() throws SQLException {
		return this.jdbcDao.getTicks();
	}
	
	@RequestMapping("/db2")
	@ResponseBody
	public Object db2() throws SQLException {
		
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
