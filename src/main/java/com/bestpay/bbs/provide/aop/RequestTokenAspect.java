package com.bestpay.bbs.provide.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RequestTokenAspect {
	@Pointcut("execution(* com.bestpay.bbs.action.SubjectAction.index(..))")
	public void subjectPreviewToken(){};
	
	@Before(value="subjectPreviewToken()")
	public void addToken(){
		//System.out.println("..add Token");
	}
}
