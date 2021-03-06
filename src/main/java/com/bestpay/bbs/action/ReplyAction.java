package com.bestpay.bbs.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bestpay.bbs.domain.Reply;
import com.bestpay.bbs.domain.Subject;
import com.bestpay.bbs.mapper.SubjectMapper;
import com.bestpay.bbs.provide.pagination.PageParameter;
import com.bestpay.bbs.service.IReplyService;

@Controller
@RequestMapping(value = "/reply")
public class ReplyAction {
	@Autowired
	private IReplyService replyService;

	@Autowired
	private SubjectMapper subjectMapper;
	
	/**
	 * 主题预览
	 * @param subjectId
	 * @param attrs
	 * @return
	 */
	@RequestMapping(value="/preview")
	public String previewSubject(int subjectId,RedirectAttributes attrs){
		//更新主题的预览次数
		subjectMapper.incrementHitsById(subjectId);
		attrs.addAttribute("subjectId", subjectId);
		return "redirect:/reply/list";
	}

	/**
	 * 回贴列表
	 * 
	 * @param subjectId
	 * @return
	 */
	@RequestMapping("/list")
	public String listReply(int subjectId,
			@RequestParam(defaultValue = "1", required = false) int page,
			ModelMap modal,RedirectAttributes attrs) {
		//根据id查找主题信息
		Subject subject = subjectMapper.findById(subjectId);
		// 设置分页属性,默认的是第一页,每页10条,可以通过构造器自定义参数
		PageParameter<Reply> pages = new PageParameter<Reply>();
		pages.setCurrentPage(page);
		// 查询条件实体
		Reply reply = new Reply();
		reply.setSubId(subjectId);
		// 分页查询参数实体设置
		pages.setEntity(reply);
		List<Reply> replys = replyService.listReply(pages);
		pages.setResults(replys);
		modal.put("pages", pages);
		modal.put("topical", subject);
		return "reply";
	}

	/**
	 * 回贴
	 * 
	 * @param subId
	 * @param content
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String addReply(int subjectId, String content) {
		//给主题增加评论人数,
		subjectMapper.incrementReplyById(subjectId);
		Reply reply = new Reply();
		reply.setSubId(subjectId);
		reply.setContent(content);
		reply.setReplyDate(new Date());
		int count = replyService.addReply(reply);
		// 获取楼层
		int floor = replyService.getReplyFloorById(reply);
		return floor + "";
	}
}
