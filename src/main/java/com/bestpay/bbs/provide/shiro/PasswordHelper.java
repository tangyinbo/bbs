package com.bestpay.bbs.provide.shiro;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.bestpay.bbs.domain.M_User;


/*
 * 加密
 */
public class PasswordHelper {
	private static  RandomNumberGenerator numberGenerator = new SecureRandomNumberGenerator();
	private static  String algorithmName = "md5";
	private static final int hashIterations = 2;
	
	/**
	 * 
	 * @param user
	 */
	public static void encryptPassword(M_User user) {
		user.setSalt(numberGenerator.nextBytes().toHex());
		String newPassword = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);
	}
	
	public static void main(String[] args) {
		/*String password = "";
		String newPassword = new SimpleHash(algorithmName, password, ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations).toHex();
		user.setPassword(newPassword);*/
	}
}
