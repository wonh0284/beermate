/**
 * 
 */
package com.beermate.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author wlee
 *
 */
@Repository
public class JdbcDao extends JdbcTemplate {

	/**
	 * @param dataSource
	 */
	@Autowired
	public JdbcDao(DataSource dataSource) {
		super(dataSource);
	}

	public List<String> getTicks() {
		return this.queryForList("SELECT tick FROM ticks", String.class);
	}
}
