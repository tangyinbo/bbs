package com.bestpay.bbs.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.M_Role;

public class TestRoleMapper extends BasicTest{
	@Autowired
	private M_RoleMapper roleMapper;
	
	@Test
	public void addRoleTest(){
		M_Role role  = new M_Role();
		role.setRoleName("testrole");
		role.setRoleDesc("testrole");
		role.setState("s0x");
		roleMapper.addRole(role);
	}
	@Test
	public void correlationPermissionsTest(){
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("roleId", 1);
		maps.put("privId", 1);
		List<Map<String,Integer>> lists = new ArrayList<Map<String,Integer>>();
		lists.add(maps);
		roleMapper.correlationPermissions(lists);
	}
	
	@Test
	public void unCorrelationPermissionsTest(){
		Map<String, Integer> maps = new HashMap<String, Integer>();
		maps.put("roleId", 1);
		maps.put("privId", 1);
		List<Map<String,Integer>> lists = new ArrayList<Map<String,Integer>>();
		lists.add(maps);
		roleMapper.unCorrelationPermissions(lists);
	}
	
	
}
