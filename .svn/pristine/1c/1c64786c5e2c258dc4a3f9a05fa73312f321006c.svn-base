package com.bestpay.bbs.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.M_User;

public class TestUserMapper extends  BasicTest{
	@Autowired
	private M_UserMapper userMapper;
	
	@Test
	public void addUserTest(){
		M_User user = new M_User();
		user.setUserName("test1");
		user.setPassword("testPasswd");
		user.setSalt("testSalt");
		user.setState("s0x");
		userMapper.addUser(user);
	}

	
	@Test
	public void findByNameTest(){
		String userName ="test1";
		M_User user =userMapper.findByName(userName);
		System.out.println(user);
	}
	
	@Test
	public void correlationRolesTest(){
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("userId", 1);
		maps.put("roleId", 1);
		List<Map<String,Integer>> lists = new ArrayList<Map<String,Integer>>();
		lists.add(maps);
		userMapper.correlationRoles(lists);
	}
	@Test
	public void unCorrelationRolesTest(){
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("userId", 1);
		maps.put("roleId", 1);
		List<Map<String,Integer>> lists = new ArrayList<Map<String,Integer>>();
		lists.add(maps);
		userMapper.unCorrelationRoles(lists);
	}
}
