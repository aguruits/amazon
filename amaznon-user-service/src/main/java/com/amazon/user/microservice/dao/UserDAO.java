package com.amazon.user.microservice.dao;

import java.sql.Types;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.amazon.user.microservice.model.User;

@Repository
public class UserDAO extends UserRepository{
	
	public List<User> getUserList() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT userId, loginId, userName, password, userType, address, contactNumber, email FROM user ORDER BY userName ASC");
		
		List<User> userList = (List<User>) jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper<>(User.class));
		return userList;
	}
	
	public User getUserforAuthenticate(User user) {
		
		String loginId  = user.getLoginId();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT userId, loginId, userName, password, userType FROM user ");
		sb.append(" WHERE loginId  = ? AND userType = 'C' " );
		
		Object[] params = {loginId };
		int[] sqlTypes = {Types.VARCHAR};
		
		try {
			user = (User) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(User.class));
			return user;
		} catch(Exception e) {
			return new User();
		}
	}

	public User getUser(User user) {
		
		String userId = user.getUserId();
		
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT userId, loginId, userName, password, userType, address, contactNumber, email FROM user ");
		sb.append(" WHERE userId = ?" );
		
		Object[] params = {userId};
		int[] sqlTypes = {Types.VARCHAR};
		
		user = (User) jdbcTemplate.queryForObject(sb.toString(), params, sqlTypes, new BeanPropertyRowMapper<>(User.class));
		
		return user;
	}
	
	public int addUser(User user) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO user VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		
		Object[] params = {user.getUserId(), user.getUserId(), user.getUserName(), user.getPassword(), user.getUserType(), user.getAddress(), user.getContactNumber(), user.getEmail()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}
	
	public int updateUser(User user) {
		
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE user SET ");
		sb.append(" userName = ?, ");
		sb.append(" password = ?, ");
		sb.append(" userType = ?, ");
		sb.append(" address = ?, ");
		sb.append(" contactNumber = ?, ");
		sb.append(" email = ? ");
		sb.append("WHERE ");
		sb.append(" userId = ? ");
		
		
		Object[] params = {user.getUserName(), user.getPassword(), user.getUserType(), user.getAddress(), user.getContactNumber(), user.getEmail(), user.getUserId()};
		int[] sqlTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		
		int rowsEffected = jdbcTemplate.update(sb.toString(), params, sqlTypes);
		
		return rowsEffected;
	}

}

