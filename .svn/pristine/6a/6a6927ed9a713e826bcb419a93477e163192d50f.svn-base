package com.bestpay.bbs.mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.bestpay.bbs.domain.M_User;

public interface M_UserMapper {
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
	M_User findByName(String userName);
	/**
	 * 关联角色
	 * @param userRoles
	 */
	void correlationRoles(List<Map<String,Integer>> userRoles);
	/**
	 * 取消关联角色
	 * @param userRoles
	 */
	void unCorrelationRoles(List<Map<String,Integer>> userRoles);
	/**
	 * 列出权限
	 * @param userName
	 * @return 
	 */
	Set<String> listPermissions(String userName);
}
