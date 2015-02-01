package com.bestpay.bbs.provide.pagination;

import java.util.List;

import org.apache.ibatis.type.Alias;

/**
 * 分页参数工具类
 * 
 * @author canton_cowboy
 * 
 */
@Alias(value = "Page")
public class PageParameter<T> {
	private T entity;// 查询条件vo
	public static final int DEFAULT_PAGE_SIZE = 10;
	private int currentPage = 1;// 当前页数
	private int pageSize;// 每页显示的条目数
	private int totalCount;// 总行数
	private int totalpage;// 总记录数
	private List<T> results;// 结果

	/**
	 * 分页拦截器用
	 * @return
	 */
	public PageParameter<T> getPage() {
		return this;
	}
	public PageParameter() {
		super();
	}

	public PageParameter(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	/**
	 * 计算总页数
	 */
	public void colculateTotalPage() {
		int totalpage = totalCount / (pageSize==0?DEFAULT_PAGE_SIZE:pageSize)
				+ (totalCount % (pageSize==0?DEFAULT_PAGE_SIZE:pageSize) == 0 ? 0 : 1);
		setTotalpage(totalpage);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return (pageSize==0?DEFAULT_PAGE_SIZE:pageSize);
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}
}
