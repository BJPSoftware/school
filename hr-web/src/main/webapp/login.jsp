<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>智慧校园人力资源管理平台-登录</title>
</head>
<body>
<form action="login/login" method="post">
    用户名:<input type="text" name="userName"/>
     密码:<input type="text" name="userPwd"/><br>
     <input type="radio" name="userCh" value="portal" checked>经典界面
     <input type="radio" name="userCh" value="desktop">类桌面界面
    <input type="submit" value="提交"/>
</form>
</body>
</html>