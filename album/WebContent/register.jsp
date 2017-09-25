<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/jqlib/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(function(){
	$.ajaxSetup({
		async:false
	});
	$("form").submit(function(){
		var flag;
		$.post("${pageContext.request.contextPath }/user/checkExists",
				{"user.userName":$("[name='user.userName']").val()},
				function(data){
					if(data=="1"){
						$("#info").html("用户名已存在，请重新输入！");
						flag=false;
					}else{
						flag=true;
					}
				});
		return flag;
	});
});
</script>
</head>
<body>
	<br />
	<br /> 注册
	<br />
	<br />
	<form method="post" action="${pageContext.request.contextPath }/user/add">
		<table>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="user.userName" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="user.userPwd" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="注册" /></td>
			</tr>
		</table>
		<div id="info"></div>
	</form>
	<a href="${pageContext.request.contextPath }/main.jsp">返回主页</a>
</body>
</html>