package com.bestpay.bbs.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestpay.bbs.domain.M_User;
import com.bestpay.bbs.mapper.M_UserMapper;
import com.bestpay.bbs.provide.shiro.PasswordHelper;
import com.bestpay.bbs.service.M_IUserService;

@Service(value="userService")
public class M_UserService implements M_IUserService {
	@Autowired
	private M_UserMapper userMapper;

	@Override
	public M_User findByUserName(String userName) {
		return userMapper.findByName(userName);
	}

	@Override
	public void addUser(M_User user) {
		PasswordHelper.encryptPassword(user);
		userMapper.addUser(user);
	}

	@Override
	public Set<String> listPermissions(String userName) {
		return userMapper.listPermissions(userName);
	}

}
