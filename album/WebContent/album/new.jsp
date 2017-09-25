<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建新相册</title>
</head>
<body>
创建新相册
<br/>
<br/>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/album/upload">
<table>
<tr><td>相册名字<input type="text" name="album.name"/></td></tr>
<tr><td>相册封面<input type="file" name="myfile"/></td></tr>
<tr><td colspan="2"><input type="button" value="创建"/></td></tr>
</table>
</form>
<br/>
</body>
</html>