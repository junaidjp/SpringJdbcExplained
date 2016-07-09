package com.junaid.training.springjdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.bov.dto.User;

public class JdbcBankOfVizDaoImpl  implements BankOfVizDao{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		}
	
	/**
	 * The below is also an example of inner methods 
	 */
	public void insert(final User usr) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		String sql = "INSERT INTO user (id, username, password) "
			+ "VALUES (?, ?, ?)";
		
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			public void setValues(PreparedStatement ps)
			throws SQLException {
			ps.setInt(1, usr.getId());
			ps.setString(2, usr.getUserName());
			ps.setString(3, usr.getPassword());
			
			}
			});
		
		
	}
	
	/**
	 * Bean Row Mapper will automatically map all your TAble columns to Bean properties
	 * :) JDBCTemplate makes this happen
	 */
	
	public User findUserById(int id){
		String sql = "SELECT * FROM user WHERE id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		User usr = (User) jdbcTemplate.queryForObject(sql,new Object[] { id } ,new BeanPropertyRowMapper(User.class));
		return usr;
	}
}
