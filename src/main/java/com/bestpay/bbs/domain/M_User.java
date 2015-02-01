package com.bestpay.bbs.domain;

import org.apache.ibatis.type.Alias;

/**
 * 后台用户
 * @author canton_cowboy
 *
 */
@Alias("mUser")
public class M_User {
	private int userId;
	private String userName;
	private String password;
	private String salt;
	private String state;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return this.userId+"_"+this.userName+"_"+this.password+"_"+this.salt;
	}
	public String getCredentialsSalt() {
		return this.userName+this.salt;
	}
}
