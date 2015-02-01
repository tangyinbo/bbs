package com.bestpay.bbs.mapper;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.M_Permission;

public class TestPermissionMapper extends BasicTest{
	@Autowired
	private M_PermissionMapper permissionMapper;
	@Test
	public void addPermissionTest(){
		M_Permission priv = new M_Permission();
		priv.setPrivName("testpriv");
		priv.setPrivUrl("/b/c/d");
		priv.setPermission("b:c:d");
		priv.setState("s0x");
		
		permissionMapper.addPermission(priv);
	}
}
