package com.amazon.user.microservice.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.user.microservice.dao.UserDAO;
import com.amazon.user.microservice.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public List<User> getUserList() {
		return userDAO.getUserList();
	}
	
	public User getUserforAuthenticate(User user) {
		User userfromDB = userDAO.getUserforAuthenticate(user);
		
		if(userfromDB != null) {
			String passwordIP = user.getPassword();
			String passwordDB = userfromDB.getPassword();
			
			if(StringUtils.isNotBlank(passwordIP)
					&& StringUtils.isNotBlank(passwordDB)
					&& StringUtils.equalsIgnoreCase(passwordIP, passwordDB)) {
				userfromDB.setIsUserAthenticated(Boolean.TRUE);
				return userfromDB;
			}
		}
		return user;
	}

	public User getUser(User user) {
		return userDAO.getUser(user);
	}
	
	public int addUser(User user) {
		return userDAO.addUser(user);
	}
	
	public int updateUser(User user) {
		return userDAO.updateUser(user);
	}

}
