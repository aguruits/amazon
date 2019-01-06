package com.amazon.ui.user.model;

import org.apache.commons.lang.StringUtils;

public class User {
	
	private String userId;
	private String loginId;
	private String userName;
	private String password;
	private String userType;
	private String address;
    private String contactNumber;
    private String email;	
    private Boolean isUserAthenticated = Boolean.FALSE;
	
    public String getUserTypeDesc() {
    	if(StringUtils.equalsIgnoreCase(userType, "e")) {
    		return "Employee";
    	} else if(StringUtils.equalsIgnoreCase(userType, "S")) {
    		return "Supplier";
    	} else 
    		return "Customer";
	}
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getIsUserAthenticated() {
		return isUserAthenticated;
	}
	public void setIsUserAthenticated(Boolean isUserAthenticated) {
		this.isUserAthenticated = isUserAthenticated;
	}
	
}
