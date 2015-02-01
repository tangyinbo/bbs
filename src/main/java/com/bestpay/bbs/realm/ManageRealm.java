package com.bestpay.bbs.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.bestpay.bbs.domain.M_User;
import com.bestpay.bbs.service.M_IUserService;

public class ManageRealm extends AuthorizingRealm {

	private M_IUserService userService;

	public M_IUserService getUserService() {
		return userService;
	}

	public void setUserService(M_IUserService userService) {
		this.userService = userService;
	}

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//授权对象
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		//获取当前用户名
		String userName = (String) principals.getPrimaryPrincipal();
		//获取权限
		Set<String> permissions = userService.listPermissions(userName);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String userName = (String) token.getPrincipal();
		M_User user = userService.findByUserName(userName);
		if (user == null) {
			throw new UnknownAccountException();// 账户不存在
		}
		// 账户的不同状态...相应操作
		if ("S0X".equals(user.getState())) {
			throw new LockedAccountException();//账户锁定
		}
		
	
		//返回认证信息
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(),user.getPassword(),ByteSource.Util.bytes(user.getCredentialsSalt()),getName());
		
		return simpleAuthenticationInfo;
	}

}
