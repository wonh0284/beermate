/**
 * 
 */
package com.beermate.web;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wlee
 *
 */
@Controller
public class HomeController {

	/*@RequestMapping("/home")
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
	*/
	@RequestMapping("/home")
	public String home() throws SQLException {
		return "home";
	}
}
