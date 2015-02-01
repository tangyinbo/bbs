package com.bestpay.bbs.domain;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 后台权限
 * @author canton_cowboy
 *
 */
@Alias("mPermission")
public class M_Permission {
	private int privId;
	private String privName;
	private String privUrl;
	private String permission;
	private String state;
	private List<M_Permission> subPrivs;
	public int getPrivId() {
		return privId;
	}
	public void setPrivId(int privId) {
		this.privId = privId;
	}
	public String getPrivName() {
		return privName;
	}
	public void setPrivName(String privName) {
		this.privName = privName;
	}
	public String getPrivUrl() {
		return privUrl;
	}
	public void setPrivUrl(String privUrl) {
		this.privUrl = privUrl;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public List<M_Permission> getSubPrivs() {
		return subPrivs;
	}
	public void setSubPrivs(List<M_Permission> subPrivs) {
		this.subPrivs = subPrivs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
