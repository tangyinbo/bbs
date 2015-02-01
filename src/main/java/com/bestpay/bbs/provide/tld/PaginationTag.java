package com.bestpay.bbs.provide.tld;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.util.StringUtils;

import com.bestpay.bbs.exception.IllegalParameterStateException;
import com.bestpay.bbs.provide.pagination.PageHelper;
import com.bestpay.bbs.provide.pagination.PageTemplate;

public class PaginationTag extends TagSupport {
	private String formName;

	private String url;
	
	private String getCommonPageHtml() throws IllegalParameterStateException{
		url  = pageContext.getRequest().getServletContext().getContextPath()+url;
		return new PageTemplate(getUrl()).getPageString();
	}
	
	private String getFormPageHtml() throws IllegalParameterStateException{
		return new PageTemplate(null).new FormPageTemplate(formName).getPageString();
	}
	
	private String getPageHtml() throws IllegalParameterStateException{
		if(!StringUtils.isEmpty(url)){
			return getCommonPageHtml();
		}else if(!StringUtils.isEmpty(formName)){
			return getFormPageHtml();
		}else{
			throw new IllegalParameterStateException("PaginationTag jstl 标签 属性url 为空...");
		}
	}

	@Override
	public int doStartTag() throws JspException {

		try {
			
			String html = getPageHtml();
			
			JspWriter write = pageContext.getOut();
			write.println(html);
		} catch (IllegalParameterStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		return super.doEndTag();
	}

	@Override
	public void release() {
		super.release();
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
