package com.bestpay.bbs.provide.pagination;

import java.util.ArrayList;
import java.util.List;

import com.bestpay.bbs.exception.IllegalParameterStateException;

public class PageTemplate {
	/**
	 * url 必须包括资源的完整路径和参数, page 参会会自动添加
	 */
	protected String url = "javascript:;";
	protected String disAbledUrl = "javascript:;";

	protected String pageContainer = "<div class='pgs'>";
	protected String pageContainerEnd = "</div>";

	protected String backToList = "<span class='pgb' id='visitedforumstmp'> <a href='#'>返回列表</a> </span>";

	protected String pageCon = "<div class='pg'>";
	protected String pageConEnd = "</div>";

	protected String pageItem = "<a href=''>";
	protected String pageItemEnd = "</a>";

	protected String ellipsisSign = "...";
	protected String pageEndItem = "<a href=''>";
	protected String pageEndItemEnd = "</a>";

	protected String pageFirstItem = "<a href=''>";
	protected String pageFirstItemEnd = "</a>";

	protected String pageSkipStart = "<label> <input type='text' name='custompage' class='px' size='2' title='输入页码，按回车快速跳转' value='";
	protected String pageSkipEnd = "' onkeydown='if(event.keyCode==13) {}'><span title='共 "
			+ PageHelper.totalpage.get()
			+ " 页'> / "
			+ PageHelper.totalpage.get() + " 页</span> </label>";

	protected String pageNext = "<a href=''>";
	protected String pageNextEnd = "下一页</a>";

	protected String pageHtml = "";
	protected List<String> pageItems = new ArrayList<String>();
	protected List<String> pageItemNames = new ArrayList<String>();
	protected String pageItemsStr = "";

	public PageTemplate(String url) {
		this.url = url;
	}

	/**
	 * 初始化pageItem
	 */
	protected int pageRange = 4;
	protected int pageItemSize = 10;

	protected void init() {
		int currentPage = PageHelper.currentPage.get();
		int totalPage = PageHelper.totalpage.get();
		if (totalPage > pageItemSize && currentPage > 6) {
			// 初始化pageItem
			// 添加第一个
			addPageFirstItem();
			addPageFrontItems();
			int startPate = currentPage;
			int endPage = totalPage;
			// 计算开始和结束页数
			if ((currentPage + pageRange) < totalPage) {
				endPage = currentPage + pageRange;
				startPate = currentPage - pageRange;
			} else {
				startPate = totalPage - pageRange * 2;
				endPage = totalPage;
			}

			for (int i = startPate; i <= endPage; i++) {
				if (currentPage == i) {
					addPageItemsFocus(i + "", i + "");
					continue;
				}
				addPageItems(i + "", i + "");
			}
			// 添加最后一个
			if (endPage < totalPage)
				addPageEndItem();
		} else {
			int endPage = totalPage < pageItemSize ? totalPage : pageItemSize;
			for (int i = 1; i <= endPage; i++) {
				if (currentPage == i) {
					addPageItemsFocus(i + "", i + "");
					continue;
				}
				addPageItems(i + "", i + "");
			}
			// 添加最后一个
			if (totalPage > pageItemSize)
				addPageEndItem();
		}
	}

	/**
	 * 获取最后个分页项
	 * 
	 * @return
	 */
	protected void addPageEndItem() {
		int totalPage = PageHelper.totalpage.get();
		addPageItems(totalPage + "", ellipsisSign + totalPage);
	}

	/**
	 * 第一个选项
	 */
	protected void addPageFirstItem() {
		addPageItems(1 + "", 1 + ellipsisSign);
	}

	/**
	 * 设置当前项样式
	 * 
	 * @param pageItemName
	 */
	protected void addPageItemsFocus(String page, String pageItemName) {
		String tempPageItem = pageItemAddDisabledUrl(page);
		String itemP1 = tempPageItem.substring(0, 3);
		String itemP2 = tempPageItem.substring(2);
		this.pageItems.add(itemP1 + "  class='active_focus'" + itemP2
				+ pageItemName + pageItemEnd);
	}

	/**
	 * 增加pageItem
	 * 
	 * @param pageItemName
	 */
	protected void addPageItems(String page, String pageItemName) {
		String tempPageItem = pageItemAddUrl(page);
		this.pageItems.add(tempPageItem + pageItemName + pageItemEnd);
	}

	/**
	 * 添加page 参数
	 * 
	 * @param page
	 * @return
	 */
	protected String pageItemAddUrl(String page) {
		String tempPageItemP1 = pageItem.substring(0, pageItem.length() - 2);
		String tempPageItemP2 = pageItem.substring(tempPageItemP1.length());
		return tempPageItemP1 + getUrl(page, null) + tempPageItemP2;

	}

	/**
	 * 
	 * @param page
	 * @return
	 */
	protected String pageItemAddDisabledUrl(String page) {
		String tempPageItemP1 = pageItem.substring(0, pageItem.length() - 2);
		String tempPageItemP2 = pageItem.substring(tempPageItemP1.length());
		return tempPageItemP1 + getUrl(page, disAbledUrl) + tempPageItemP2;

	}

	/**
	 * 拼接url
	 * 
	 * @param page
	 * @return
	 */
	protected String getUrl(String page, String myUrl) {
		String tempUrl = "";
		if (myUrl == null) {
			tempUrl = url == null ? disAbledUrl : url;
		} else {
			tempUrl = myUrl;
		}

		if (myUrl != null && myUrl.equals(disAbledUrl)) {
			return tempUrl;
		} else {
			if (tempUrl.contains("?")) {
				return tempUrl + "&page=" + page;
			}
			return tempUrl + "?page=" + page;
		}

	}

	/**
	 * 上一页
	 */
	protected void addPageFrontItems() {
		addPageItems(PageHelper.currentPage.get() - 1 + "", "上一页");
	}

	/**
	 * 获取分页项
	 * 
	 * @return
	 * @throws IllegalParameterStateException
	 */
	protected String getPageItemsStr() throws IllegalParameterStateException {
		if (pageItems == null || pageItems.size() == 0)
			throw new IllegalParameterStateException(
					" PageTemplate  属性 pageItems 为空,请检查init(...) 初始化");
		StringBuilder sb = new StringBuilder();
		for (String item : pageItems) {
			sb.append(item);
		}
		return sb.toString();
	}

	/**
	 * 跳转页面
	 * 
	 * @return
	 */
	protected String getPageSkip() {
		return pageSkipStart + PageHelper.currentPage.get() + pageSkipEnd;
	}

	/**
	 * 下一页
	 * 
	 * @return
	 */
	protected String getPageNext() {
		String tempPageNextItem = null;
		int currentPage = PageHelper.currentPage.get();
		int totalPage = PageHelper.totalpage.get();
		if (currentPage < totalPage) {
			tempPageNextItem = pageItemAddUrl(PageHelper.currentPage.get() + 1
					+ "");
		} else {
			tempPageNextItem = pageItemAddDisabledUrl(null);
			String itemP1 = tempPageNextItem.substring(0, 3);
			String itemP2 = tempPageNextItem.substring(2);
			return itemP1 + " class='disabled'  style='cursor:default'"
					+ itemP2 + pageNextEnd;
		}
		return tempPageNextItem + pageNextEnd;

	}

	// 获取列表展示html
	public String getPageString() throws IllegalParameterStateException {
		init();
		if(pageItems==null||pageItems.size()==0)return "";
		return pageHtml//
				+ pageContainer// -
				+ backToList//
				+ pageCon// --
				+ getPageItemsStr() + getPageSkip()
				+ getPageNext()
				+ pageConEnd// --
				+ pageContainerEnd// -
		;
	}

	public static void main(String[] args)
			throws IllegalParameterStateException {
		/*
		 * PageTemplate template=new PageTemplate("http://localhost:aaa?b=2");
		 * template.addPageItems(1+"");
		 * 
		 * System.out.println(template.getPageItemsStr());
		 */

		PageHelper.currentPage.set(7);
		PageHelper.totalpage.set(100);
		/*
		 * String result = new PageTemplate("http://localhsot://abc")
		 * .getPageString(); System.out.println(result);
		 */

		PageTemplate temp = new PageTemplate(null).new FormPageTemplate(
				"myForm");
		System.out.println(temp.getPageString());

	}

	/**
	 * 表单提交分页模板
	 * 
	 * @author canton_cowboy
	 * 
	 */
	public class FormPageTemplate extends PageTemplate {
		public FormPageTemplate(String formName) {
			super(null);
			this.formName = formName;
		}

		protected String formName;

		public String getFormName() {
			return formName;
		}

		public void setFormName(String formName) {
			this.formName = formName;
		}

		@Override
		protected void addPageItems(String page, String pageItemName) {
			String tempPageItem = pageItemAddDisabledUrl(page);
			tempPageItem = addJsEvent(tempPageItem, page);
			this.pageItems.add(tempPageItem + pageItemName + pageItemEnd);
		}

		/**
		 * 添加js事件
		 * 
		 * @param page
		 * @return
		 */
		private String addJsEvent(String temp, String page) {
			String tempPageItemP1 = temp.substring(0, temp.length() - 1);
			String tempPageItemP2 = temp.substring(temp.length() - 1);
			return tempPageItemP1 + " " + getClickStr(page) + tempPageItemP2;
		}

		/**
		 * 生成事件字符串
		 * 
		 * @param page
		 * @return
		 */
		private String getClickStr(String page) {
			return "onclick=Pagination.submit('" + this.formName + "'" + ","
					+ page + ")";
		}

		@Override
		protected String getPageNext() {
			String tempPageNextItem = null;
			int currentPage = PageHelper.currentPage.get();
			int totalPage = PageHelper.totalpage.get();
			if (currentPage < totalPage) {
				tempPageNextItem = pageItemAddDisabledUrl(PageHelper.currentPage
						.get() + 1 + "");
				tempPageNextItem = addJsEvent(tempPageNextItem,
						PageHelper.currentPage.get() + 1 + "");
			} else {
				tempPageNextItem = pageItemAddDisabledUrl(null);
				String itemP1 = tempPageNextItem.substring(0, 3);
				String itemP2 = tempPageNextItem.substring(2);
				return itemP1 + " class='disabled'  style='cursor:default'"
						+ itemP2 + pageNextEnd;
			}
			return tempPageNextItem + pageNextEnd;

		}
	}
}
