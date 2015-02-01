var DomUtils = DomUtils||{};
$.extend(DomUtils,
{
	//回复选项的生成
	generatorReplyItem:function(subId){
		//获取文本框内容
		var data = CKEDITOR.instances.replyEditor.getData();
		if(!data){
			alert("评论内容不能为空...");
			return;
		}
		var self = this;
		var item =$('<div class="repl_item">'+
					'<div class="reply_personal">'+
						'<img src="/bestpay-bbs/resource/image/a.jpg" alt="头像" width="76px" height="76px"/>'+
					'</div>'+
					'<div class="reply_msg">'+
						'<div  class="reply_detail">'+
						'<a>作者名称</a>'+
							'<span class="detail_as">发表于几天前</span>'+
							'<span class="reply_floor">#100</span>'+
						'</div>'+
						'<div class="reply_content">'+
						'</div>'+
					'</div>'+
				'</div>');
		function setContent(content){
				item.find(".reply_content").html(content);
		}
		//更新评论数,暂时先这样,以后后台获取
		function updateReplyNumber(){
			var num =parseInt($(".reply_num").html());
			$(".reply_num").html(num+1);
			
		}
		var contentEle =$(".edits");
		//获取文本框内容
		var conetent =contentEle.html();
		function showItem(floor){
			item.addClass("repl_item_self");
			item.find(".reply_personal").addClass("reply_personal_self");
			setContent(data);//设置内容
			item.find(".reply_floor").html("#"+floor);
			$(".repl_container").append(item);
			updateReplyNumber();//更新评论数
			contentEle.html('');//清空编辑框
		}
		self.postReply({subjectId:subId,content:data},showItem);
	},
	postReply:function(data,callback){
		$.ajax({
			   type: "POST",
			   url: "/bestpay-bbs/reply/add",
			   cache:false,
			   data:data,
			   success: function(msg){
				   CKEDITOR.instances.replyEditor.setData("");
				   callback(msg);
			   }
		});
	}
}
);
/**
 * ckeditor 
 */
$(function(){
	  CKEDITOR.replace('replyEditor',{
		 width:'100%',
		 height:"200px",
		customConfig: '/bestpay-bbs/ckeditor/customer/replyconf.js'
	  });
});