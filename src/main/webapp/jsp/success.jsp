<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	${msg}</br>
	<!-- 登录账号-->
	<a href="${pageContext.request.contextPath }/jsp/login.jsp">--登录--</a>
	<!-- 注册账号 -->
	<a href="${pageContext.request.contextPath }/jsp/regist.jsp">--注册--</a>
</body>
</html>