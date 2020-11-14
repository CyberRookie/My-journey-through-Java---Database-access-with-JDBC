package com.generic.user.login.model;
/**
 * 10/16/20 6:30PM
 * @author MARKR
 *Trying to validate username
 *password against DB.
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public String username;
	public String password;
	
	private String errorMsg;
	
	public LoginBean(){	
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
		
	public boolean isValidUser()
	{
		if ( "username".equals(this.username) && "password".equals(this.password));
		System.out.println("Valid user Mofo! SumBitch Rev 2!");
		//	return isValidUser();
		return true;
	}	//Validation can happen here from number of sources
}		//for example database, LDAP etc. 
		//We are just going to hard-code valid user name and
		//password here.



