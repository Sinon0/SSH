<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页</title>
</head>
<body>
	登录
	<br />
	<br />
<form method="post" action="${pageContext.request.contextPath }/user/login">
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
				<td colspan="2"><input type="submit" value="登录" /></td>
			</tr>
		</table>
	</form>
	<a href="${pageContext.request.contextPath }/main.jsp">返回主页</a>
</body>
</html>