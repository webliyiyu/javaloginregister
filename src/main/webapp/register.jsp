<%--
  Created by IntelliJ IDEA.
  User: 忆白
  Date: 2024/3/14
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register" method="post">
    用户名<input required type="text" name="username"><br>
    密码<input required type="text" name="password"><br>
    昵称<input required type="text" name="nickname"><br>
    地址<input required type="text" name="address"><br>
    邮箱<input required type="text" name="email"><br>
    性别<input required type="radio" name="gender" value="1">男
    <input required type="radio" name="gender" value="0">女
    <br>
    <input required type="submit" value="注册">
</form>
</body>
</html>
