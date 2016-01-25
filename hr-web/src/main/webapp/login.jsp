<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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