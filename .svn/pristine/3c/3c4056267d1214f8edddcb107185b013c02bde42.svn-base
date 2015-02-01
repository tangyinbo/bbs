package com.bestpay.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestpay.bbs.domain.Reply;
import com.bestpay.bbs.mapper.ReplyMapper;
import com.bestpay.bbs.provide.pagination.PageParameter;
import com.bestpay.bbs.service.IReplyService;

@Service
public class ReplyService implements IReplyService {
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	public List<Reply> listReply(PageParameter<Reply> page) {
		return replyMapper.listReplyBySubjectPage(page);
	}
	@Override
	public int addReply(Reply reply){
		return replyMapper.addReply(reply);
	}
	@Override
	public int getReplyFloorById(Reply reply) {
		return replyMapper.getReplyFloorById(reply);
	}

	

}
