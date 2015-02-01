package com.bestpay.bbs.service.manage;

import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.M_User;
import com.bestpay.bbs.service.M_IUserService;

public class TestUserService extends BasicTest {
	@Autowired
	private M_IUserService userService;
	
	@Test
	public void addUserTest(){
		M_User user = new M_User();
		user.setUserName("tang");
		user.setPassword("123456");
		user.setState("S0A");
		userService.addUser(user);
	}
	
	@Test
	public void listPermissionsTest(){
		String userName="test1";
		Set<String> results =userService.listPermissions(userName);
		System.out.println(results);
	}
}
