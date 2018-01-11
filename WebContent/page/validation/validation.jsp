<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证的页面</title>
</head>
<body>

	<div align="center" style="top:200px;">
		<form action="${pageContext.request.contextPath }/ValidationServlet" method="post">
			用户名：<input type="text" name="username" value/><br/><br/>
			密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" value=""/><br/><br/>
			email：<input type="text" name="email" value=""/><br/><br/>
			age：<input type="text" name="age" value=""/><br/><br/>
			loginDate：<input type="date" name="loginDate" value=""/><br/><br/>
			expiryDate：<input type="date" name="expiryDate" value=""/><br/><br/>
			<input type="submit" name="验证"/>
		</form>
	</div>

</body>
</html>