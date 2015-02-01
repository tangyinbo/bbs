package com.bestpay.bbs.mapper;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.Reply;

public class TestReplyMapper extends BasicTest {
	@Autowired
	private ReplyMapper replyMapper;

	@Test
	public void addReplyTest() {
		for(int i=101;i<150;i++){
			Reply reply = new Reply();
			reply.setSubId(1);
			reply.setContent("我是一个回复内容"+i);
			reply.setReplyDate(new Date());
			reply.setAuthorId(1);
			replyMapper.addReply(reply);
		}
	}
}
