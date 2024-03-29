<%--
  Created by IntelliJ IDEA.
  User: 忆白
  Date: 2024/3/14
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.buercorp.wangyu.pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<style>
    a {
        text-decoration: none;
        color: black;
    }
</style>
<body>
<%--<%--%>
<%--    //首先将request域对象存储在pageContext中--%>
<%--    pageContext.setAttribute("req", request); // 那么后续调用 ${pageContext.request} ==> ${req}--%>
<%--    pageContext.setAttribute("session", session); // 那么后续调用 ${pageContext.session} ==> ${session}--%>
<%--%>--%>
<%
    User user = (User) session.getAttribute("user");
//    pageContext.setAttribute("req", request);
%>
<h1>${user.nickname} 欢迎登录 </h1>
<h3>当前在线人数:</h3>
<ul>
    <%
        int number = (Integer) session.getAttribute("number");
    %>
    <li>当前在线人数：${ number }</li>
</ul>


<h3>请求信息</h3>
<ul>
    <li>协议： ${ req.scheme }</li>
    <li>服务器 ip：${ req.serverName }</li>
    <li>服务器端口：${ req.serverPort }</li>
    <li>获取工程路径：${ req.contextPath }</li>
    <li>获取请求方法：${ req.method }</li>
    <li>获取客户端 ip 地址：${ req.remoteHost }</li>
    <li>获取请求的 url 地址：${ req.requestURL }</li>
</ul>

<h3>用户信息</h3>
<ul>
    <li>用户名：${ user.username }</li>
    <li>密码：${ user.password }</li>
    <li>地址：${ user.address }</li>
    <li>昵称：${ user.nickname }</li>
    <li>性别：${ user.gender == 1 ? "男" : "女" }</li>
    <li>邮箱：${ user.email }</li>
    <li>状态：${ user.status == 1 ? "在线" : "离线" }</li>
</ul>

<button><a href="login.jsp">退出登录</a></button>
<button><a href="logout">注销账户</a></button>
<button><a href="update.jsp">修改信息</a></button>

</body>
</html>
