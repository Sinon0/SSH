<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>相册页面</title>
</head>
<body>
<s:if test="#session.USER==null">
<jsp:forward page="/main.jsp"></jsp:forward>
</s:if>
<a href="${pageContext.request.contextPath }/album/new.jsp">创建新相册</a>
</body>
</html>