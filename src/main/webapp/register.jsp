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
    用户名<input type="text" name="username"><br>
    密码<input type="text" name="password"><br>
    昵称<input type="text" name="nickname"><br>
    地址<input type="text" name="address"><br>
    邮箱<input type="text" name="email"><br>
    性别<input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女
    <br>
    <input type="submit" value="注册">
</form>
</body>
</html>
