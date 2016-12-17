<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>登录</title>
</head>
<body>
<form name="loginForm" action="/User_login.action" method="post">
    用户名：
    <input type="text" name="userName" />
    密码：
    <input type="password" name="password" />

    <input type="submit" value="submit" />
</form>


</body>
</html>
