package com.bestpay.bbs.action;

import com.alibaba.fastjson.JSON;
import com.bestpay.bbs.domain.Subject;
import com.bestpay.bbs.mapper.SubjectMapper;
import com.bestpay.bbs.provide.pagination.PageParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Scope("prototype")
@Controller
public class SubjectAction {

    @Autowired
    private SubjectMapper subjectMapper;

	@RequestMapping(value = "/index")
	public ModelAndView index(@RequestParam(value = "postType", required = true, defaultValue = "0")int postType,
                              @RequestParam(value = "sortType", required = true, defaultValue = "0")int sortType,
                              @RequestParam(value = "currentPage", required = true, defaultValue = "1")int currentPage) throws Exception {

        System.out.println("postType="+postType);
        System.out.println("sortType="+sortType);
        System.out.println("currentPage="+currentPage);
        //起码指定下帖子类型嘛 /0 默认全部 1 吐槽类 2 活动发起类 3 建议类 4 分享类
        //排序类型 0 默认最新 1 最热  2 精华
        //分页获取所有帖子
        Subject subject = new Subject();
        subject.setPostType(postType);
        subject.setSortType(sortType);
        PageParameter pageParameter = new PageParameter();
        pageParameter.setPageSize(10);
        pageParameter.setCurrentPage(currentPage);
        pageParameter.setEntity(subject);
        List<Subject> list = subjectMapper.listSubjectPage(pageParameter);

        for (Subject sj : list) {
            System.out.println(sj.getCreateDate() + " = " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sj.getCreateDate()));
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("list", list);
        mav.addObject("postType", postType);
        mav.addObject("sortType", sortType);
        mav.addObject("currentPage", currentPage);
        mav.addObject("totalpage", pageParameter.getTotalpage());

        System.out.println(pageParameter.getTotalCount());
        System.out.println(pageParameter.getTotalpage());
        return mav;
	}

    private static final String POSTED_RETCODE = "RETCODE";
    private static final String POSTED_RETMSG = "RETMSG";
	@RequestMapping("/posted")
	@ResponseBody()
	public String posted(@RequestParam(value = "postTitle", required = true)String title,
                         @RequestParam(value = "postContent", required = true)String content,
                         @RequestParam(value = "postType", required = true)int typeId){

        Map<String, String> retMap = new HashMap<String, String>();
        if (StringUtils.isEmpty(typeId)) {
            retMap.put(POSTED_RETCODE, "1");
            retMap.put(POSTED_RETMSG, "亲,起码指定下帖子类型嘛!");
            return JSON.toJSONString(retMap);
        } else if (StringUtils.isEmpty(title)) {
            retMap.put(POSTED_RETCODE, "2");
            retMap.put(POSTED_RETMSG, "亲,您的帖子标题呢!");
            return JSON.toJSONString(retMap);
        } else if (StringUtils.isEmpty(content)) {
            retMap.put(POSTED_RETCODE, "3");
            retMap.put(POSTED_RETMSG, "亲,说好的帖子内容呢!");
            return JSON.toJSONString(retMap);
        }
        try {
            Subject subject = new Subject();
            subject.setAuthorId(0);
            subject.setTitle(title);
            subject.setContent(content);
            subject.setSubTypeId(typeId);
            subject.setReply(0);
            subject.setHits(0);
            subject.setCreateDate(new Date());

            subjectMapper.addSubject(subject);
            retMap.put(POSTED_RETCODE, "0");
            retMap.put(POSTED_RETMSG, "亲,发帖成功!");
        } catch (Exception e) {
            e.printStackTrace();
            retMap.put(POSTED_RETCODE, "4");
            retMap.put(POSTED_RETMSG, "亲,发帖失败!");
        }
        return JSON.toJSONString(retMap);
	}
}
