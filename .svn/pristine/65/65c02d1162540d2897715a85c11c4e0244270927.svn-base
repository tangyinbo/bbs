package com.bestpay.bbs.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.Reply;
import com.bestpay.bbs.provide.pagination.PageParameter;
import com.bestpay.bbs.service.impl.ReplyService;

public class TestReplyService extends BasicTest{
	@Autowired
	private IReplyService replyService;
	
	
	
	@Test
	public void listReply(){
		PageParameter<Reply> page = new PageParameter<Reply>();
		Reply reply = new Reply();
		reply.setSubId(1);
		page.setCurrentPage(2);
		page.setEntity(reply);
		List<Reply> replys =replyService.listReply(page);
		System.out.println("-------------------");
		System.out.println(replys.size());
		for(Reply rep:replys){
			System.out.println(rep);
		}
	}
}
