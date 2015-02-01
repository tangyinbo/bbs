package com.bestpay.bbs.mapper;

import com.bestpay.bbs.domain.Subject;
import com.bestpay.bbs.provide.pagination.PageParameter;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface SubjectMapper {

	public void addSubject(Subject subject);

	public Subject selectSubjectById(int id);

	@Select("select * from t_bbs_subject where title =#{title}")
	@ResultMap("Subject")
	public Subject selectSubjectByTitle(String title);
	public List<Subject> listSubjectPage(PageParameter<Subject> page);
	@Select("select * from t_bbs_subject where sub_id =#{subjectId}")
	@ResultMap("Subject")
	public Subject findById(int subjectId);

	@Update("update t_bbs_subject set hits = hits+1 where sub_id=#{subjectId}")
	public void incrementHitsById(int subjectId);
	
	@Update("update t_bbs_subject set reply = reply+1 where sub_id=#{subjectId}")
	public void incrementReplyById(int subjectId);
	
}
