package com.bestpay.bbs.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import com.bestpay.bbs.basic.BasicTest;

public class ShiroTest extends BasicTest{
	@Test
	public void test1(){
		Subject subject =SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken("tang", "123456");
		subject.login(token);
	}
}
