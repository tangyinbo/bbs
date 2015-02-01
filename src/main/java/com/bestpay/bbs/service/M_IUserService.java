package com.bestpay.bbs.service;

import java.util.Set;

import com.bestpay.bbs.domain.M_User;

public interface M_IUserService {
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(M_User user);
	/**
	 * 根据用户名查找用户
	 * @param userName
	 * @return
	 */
	M_User findByUserName(String userName);
	/**
	 * 获取用户的所有权限
	 * @param userName
	 * @return
	 */
	Set<String> listPermissions(String userName);
}
