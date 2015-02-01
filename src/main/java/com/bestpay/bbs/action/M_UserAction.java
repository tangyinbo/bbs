package com.bestpay.bbs.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bestpay.bbs.service.M_IUserService;

@Controller
@RequestMapping("/manage")
public class M_UserAction {
	@Autowired
	private M_IUserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String userName,String password,ModelMap modelMap){
		Subject subject = SecurityUtils.getSubject();
		AuthenticationToken token = new UsernamePasswordToken(userName, password);
		
		subject.login(token);
		Session session =subject.getSession();
		//session.setAttribute(key, value)
	/*	try {
		    currentUser.login( token );
		    //if no exception, that's it, we're done!
		} catch ( UnknownAccountException uae ) {
		    //username wasn't in the system, show them an error message?
		} catch ( IncorrectCredentialsException ice ) {
		    //password didn't match, try again?
		} catch ( LockedAccountException lae ) {
		    //account for that username is locked - can't login.  Show them a message?
		} 
		    ... more types exceptions to check if you want ...
		} catch ( AuthenticationException ae ) {
		    //unexpected condition - error?
		}*/
		
		return "WEB-INF/manage/main";
	}
	
	@RequestMapping("/test")
	@ResponseBody
	@RequiresPermissions(value="f:f")
	public String testPermission(String userName){
		//get the current Subject
		@SuppressWarnings("unused")
		Subject currentUser =  SecurityUtils.getSubject();
		boolean per =currentUser.isPermitted("f:f");
		String user =(String) currentUser.getPrincipal();
		return "hello tangyinbo";
	}
}
