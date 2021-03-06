<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="cow" uri="http://com.bestpay.bbs/jsp/jstl/cow"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath }/css/css/reply.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery.1.11.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/utils.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/reply.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/pagination.js"></script>
<script src="${pageContext.request.contextPath }/ckeditor/ckeditor.js"></script>
</head>
<body>
	<!--主题回复 s-->
	<div class="bbs_reply_container">
		<!-- 头部公司logo-->
		<div class="m-heading">
			<img
				src="${pageContext.request.contextPath }/resource/image/bg_trans.png">
		</div>
		<!--主题介绍 s-->
		<div class="bbs_subject_intr">
			<div class="subject_hot" style="">
				预览人数:<span class="hl">${topical.hits}</span>,评论数:<span
					class="reply_num hl">${topical.reply}</span>
			</div>
			<img src="${pageContext.request.contextPath }/resource/image/a.jpg" width="48" height="48" style="float:left" />
			<h1>
				<a href="javascript:void();">${topical.title }</a>
			</h1>

		</div>
		<!--主题介绍 s-->
		<!--左边布局 s-->
		<div class="bbs_reply_container_left">

			<!--主题内容 s-->
			<div class="subject_content">${topical.content}</div>
			<!--主题内容 e-->
			<h3 class="front_content">
				共<span class="reply_num hl">${topical.reply}</span>个关于闹饥荒的评论,最后回复时间...
			</h3>
			<!--分页条 s-->
			<%-- 	<cow:pagination formName="myForm" /> --%>
			<cow:pagination formName="myForm" />
			<!--分页条 e-->

			<!--回复内容 s-->
			<div class="repl_container">
				<c:forEach items="${pages.results}" var="reply" varStatus="status">
					<div class="repl_item">
						<!--回贴人信息 s-->
						<div class="reply_personal">
							<img
								src="${pageContext.request.contextPath }/resource/image/a.jpg"
								alt="头像" width="76px" height="76px" />

						</div>
						<!--回帖人信息 e-->
						<!--回贴信息 s-->
						<div class="reply_msg">
							<div class="reply_detail">
								<a>作者名称</a> <span class="detail_as">发表于${reply.replyDate}</span>
								<span class="reply_floor">#${(pages.currentPage-1)*pages.pageSize+(status.index+1)
									}</span>
							</div>

							<div class="reply_content">${reply.content }</div>
						</div>
						<!--回贴信息  e-->
					</div>
				</c:forEach>
			</div>
			<!--回复内容 e-->

			<!--分页条 s-->
			<form action="${pageContext.request.contextPath }/reply/list"
				name="myForm" method="post">
				<input name="subjectId" type="hidden" value="${topical.subId}" />
			</form>
			<cow:pagination formName="myForm" />
			<!--分页条 e-->

			<!--文本编辑区域 s-->
			<div class="cotent_edit">
				<!-- 	<div class="edits" contenteditable="true"></div> -->
				<textarea rows="" cols="" id="replyEditor"></textarea>
				<P class="submit_op">
					<button onclick="DomUtils.generatorReplyItem(${topical.subId})">发表回复</button>
				</P>
			</div>
			<!--文本编辑区域 e-->
		</div>
		<!--左边布局 e-->

		<!--右边布局 s-->
		<div class="bbs_reply_container_right">
			<!--浮动功能 s-->
			<div class="reply_bbs_fn">收费广告</div>
			<!--浮动功能 s-->

			<!--其他 s-->
			<div class="reply_bbs_adv" style="">收费广告</div>
			<!--其他 s-->
		</div>
		<!--右边布局 e-->
	</div>
	<!--主题回复 e-->
</body>
</html>