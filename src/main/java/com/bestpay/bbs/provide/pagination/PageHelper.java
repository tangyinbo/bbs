package com.bestpay.bbs.provide.pagination;

import java.util.List;

/**
 * 分页帮助类
 * @author canton_cowboy
 *
 */
public class PageHelper {
	
	public static ThreadLocal<Integer> currentPage=new ThreadLocal<Integer>();// 当前页数
	public static ThreadLocal<Integer> pageSize=new ThreadLocal<Integer>();// 每页显示的条目数
	public static ThreadLocal<Integer> totalCount=new ThreadLocal<Integer>();// 总行数
	public static ThreadLocal<Integer> totalpage=new ThreadLocal<Integer>();// 总记录数
	
	public static void initPageHandler(PageParameter<Object> page){
		currentPage.set(page.getCurrentPage());
		pageSize.set(page.getPageSize());
		totalCount.set(page.getTotalCount());
		totalpage.set(page.getTotalpage());
	}
	
	public static void releasePageHandler(){
		currentPage.remove();
		pageSize.remove();
		totalCount.remove();
		totalpage.remove();
	}
}
