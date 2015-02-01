package com.bestpay.bbs.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

/**
 * 回贴
 * 
 * @author canton_cowboy
 * 
 */
@Alias("reply")
public class Reply {
	private int repId;
	private int subId;
	private String content;
	private int authorId;
	private Date replyDate;
	private int iconId;
	public int getRepId() {
		return repId;
	}
	public void setRepId(int repId) {
		this.repId = repId;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public int getIconId() {
		return iconId;
	}
	public void setIconId(int iconId) {
		this.iconId = iconId;
	}
	
	@Override
	public String toString() {
		return "replyId:"+this.getRepId()+"subId:"+this.getSubId()+" \tcontent:"+this.getContent();
	}
}
