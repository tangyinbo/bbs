package com.bestpay.bbs.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bestpay.bbs.basic.BasicTest;
import com.bestpay.bbs.domain.SubJect;
import com.bestpay.bbs.provide.pagination.PageParameter;

public class TestSubjectMapper extends BasicTest{
	@Autowired
	private SubjectMapper subjectMapper;
	private static final Logger log = LoggerFactory.getLogger(TestSubjectMapper.class);
	
	@Test
	public void addSubjectTest(){
		SubJect subject = new SubJect();
		subject.setAuthorId(1);
		subject.setTitle("testTitle");
		subject.setContent("hello subject");
		subject.setCreateDate(new Date());
		subject.setModifyDate(new Date());
		subjectMapper.addSubject(subject);
	}
	
	@Test
	public void selectSubjectByIdTest(){
		SubJect subject =subjectMapper.selectSubjectById(1);
		System.out.println(subject);
	}
	@Test
	public void selectSubjectByTitleTest(){
		SubJect subject =subjectMapper.selectSubjectByTitle("testTitle1");
		log.info("hello tangyinbo");
		System.out.println(subject);
	}
	@Test
	public void listSubjectPageTest(){
		PageParameter<SubJect> page = new PageParameter<SubJect>(1,5);
		List<SubJect> results  =subjectMapper.listSubjectPage(page);
		System.out.println(results.size());
		for(SubJect s:results){
			System.out.println(s);
		}
	}
}
