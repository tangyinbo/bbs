package com.bestpay.bbs.service;

import java.util.List;

import com.bestpay.bbs.domain.Reply;
import com.bestpay.bbs.provide.pagination.PageParameter;

public interface IReplyService {
	List<Reply> listReply(PageParameter<Reply> page);
	public int addReply(Reply reply);
	public int getReplyFloorById(Reply reply);
}
