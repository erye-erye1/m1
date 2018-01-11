<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>

	<div align="center" style="top:200px;">
		<h1>${msg }</h1>
		<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
			用户名：<input type="text" name="username" value/><br/><br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" value=""/><br/><br/>
			<input type="submit" name="登录"/>
		</form>
	</div>

</body>
</html>