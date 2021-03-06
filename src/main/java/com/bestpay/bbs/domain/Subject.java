package com.bestpay.bbs.domain;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 主题opvo类
 * 
 * @author canton_cowboy
 * 
 */
@Alias("subject")
public class Subject {
	private int subId;// 主题id
	private int authorId;// 作者id
	private String title;// 标题
	private String content;// 内容
	private int reply;// 回复次数
	private int hits;// 点击次数
	private Date createDate;// 创建时间
	private Date modifyDate;// 最后回复时间
	private int iconId;// 图标id
	private int subTypeId;// 板块类型
	private int isElite;// 是否精华
	private int isTop;// 是否置顶
	private int isLock;// 是否禁止回复
    private int support;//赞
    private int top;//顶
    private int sortType; //排序类型
    private int postType; //帖子类型

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReply() {
		return reply;
	}

	public void setReply(int reply) {
		this.reply = reply;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getIconId() {
		return iconId;
	}

	public void setIconId(int iconId) {
		this.iconId = iconId;
	}

	public int getSubTypeId() {
		return subTypeId;
	}

	public void setSubTypeId(int subTypeId) {
		this.subTypeId = subTypeId;
	}

	public int getIsElite() {
		return isElite;
	}

	public void setIsElite(int isElite) {
		this.isElite = isElite;
	}

	public int getIsTop() {
		return isTop;
	}

	public void setIsTop(int isTop) {
		this.isTop = isTop;
	}

	public int getIsLock() {
		return isLock;
	}

	public void setIsLock(int isLock) {
		this.isLock = isLock;
	}

    public int getSortType() {
        return sortType;
    }

    public void setSortType(int sortType) {
        this.sortType = sortType;
    }

    public int getPostType() {
        return postType;
    }

    public void setPostType(int postType) {
        this.postType = postType;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

//	@Override
//	public String toString() {
//		return this.subId+":"+this.authorId+":"+this.title+":"+this.content;
//	}
}
