<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/script/jquery-1.8.3.min.js">
	
</script>
<script type="text/javascript">
	function aa() {
	//alert("${pageContext.request.contextPath }")
		var datas = $("form").serialize();
		$.ajax({
			type : "POST",
			url : "subject/ajax2",
			data :datas,
			success : function(msg) {
				alert("Data Saved: " + msg);
			}
		});
	}
</script>
</head>
<body>
	<form name="test" onsubmit="return false;">
		<input placeholder="name" type="text" name="name" /> <input
			placeholder="age" type="text" name="age" />
		<button onclick="aa()">submit</button>
	</form>
</body>
</html>