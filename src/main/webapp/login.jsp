<%--
  Created by IntelliJ IDEA.
  User: 忆白
  Date: 2024/3/14
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form action="login" method="post">--%>
<%--    用户名<input type="text" name="username"><br>--%>
<%--    密码<input type="text" name="password"><br>--%>
<%--    <input type="submit" value="登录">--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>登入页面</title>

</head>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    a {
        line-height: 30px;
        text-decoration: none;
        color: #fff;
    }

    input,
    button,
    div {
        border-radius: 5px;
    }

    body {
        display: flex;
        height: 100vh;
        background: linear-gradient( #20d0fe,#4b8dfe);

    }

    .box {
        margin: auto;
    }

    .login {
        padding: 20px 40px;
        width: 450px;
        height: 395px;
        background-color: rgba(0, 0, 0, 0.4);
    }

    .nav-conter input:first-child {
        margin-top: 55px;
    }

    .nav-conter input {
        margin-top: 20px;
        height: 40px;
        width: 300px;
    }

    .tab-nav {
        display: flex;
        justify-content: center;
    }

    .tab-nav a {
        position: relative;
        font-size: 20px;
        color: #fff;
    }

    .tab-nav a::before {
        content: '';
        display: block;
        width: 0;
        height: 3px;
        position: absolute;
        bottom: -4px;
        background-color: #e0e0e0;
        border-radius: 2px;
    }

    .tab-nav a.active::before {
        width: 100%;
        left: 0;
    }

    .tab-pane {
        /* display: none; */
        text-align: center;
        margin: 15px auto 0;
        width: 300px;
        height: 300px;
    }

    .input-group {
        position: relative;
    }

    .input {
        border: solid 2px #d3d3d3;
        border-radius: 16px;
        background: none;
        padding: 16px;
        font-size: 16px;
        color: #f5f5f5;
        transition: border 150ms cubic-bezier(0.4, 0, 0.2, 1);
    }

    .user-label {
        position: absolute;
        left: 15px;
        top: 47px;
        color: #f0efef;
        pointer-events: none;
        transform: translateY(16px);
        transition: 150ms cubic-bezier(0.4, 0, 0.2, 1);
    }

    .input:focus,
    input:valid {
        outline: none;
        border: 1.5px solid #fff;
    }

    .input:focus ~ label,
    input:valid ~ label {
        transform: translateY(-50%) scale(0.8);
        /* 背景颜色 */
        /* background-color: #fff; */
        padding: 0 5px;
        color: #fff;
    }

    .tab-pane span {
        cursor: pointer;
        display: block;
        margin-top: 10px;
    }

    .login .ures {
        margin-top: 6px;
        text-align: center;
        color: #e0e0e0;
        font-size: 16px;
    }

    .login .ures input {
        width: 20px;
        height: 20px;
        margin-top: 0;
        /* 表单与文字对齐 */
        vertical-align: middle;
    }

    .reglogin {
        text-align: center;
    }

    .login button {
        margin-left: 20px;
        margin-top: 10px;
        width: 80px;
        height: 35px;
        border: solid 2px #d3d3d3;
        cursor: pointer;
    }

    .login button:first-child {
        margin-left: 0;
    }
</style>
<body>
<div class="box">
    <form action="login" method="post" autocomplete="off">
        <div class="login">
            <div class="tab-nav">
                <a href="javascript:" class="active" data-id="0">账户登入</a>

                <!-- 点击条 -->
                <!-- <div class="active"></div> -->
            </div>
            <div class="nav-conter">
                <!-- 账户登入-->
                <div class="tab-pane">
                    <!-- 表单非空 -->
                    <!-- <input required type="text" placeholder="账户" name="uname">
                    <input required type="password" placeholder="密码" name="password"> -->
                    <div class="input-group">
                        <input required="" type="text"  autocomplete="off" class="input" name="username">
                        <label class="user-label">账号</label>
                    </div>
                    <div class="input-group">
                        <input required="" type="password"  autocomplete="off" class="input" name="password">
                        <label class="user-label">密码</label>
                    </div>
                    <div class="ures">
                        <input type="checkbox" name="agree">请勾选用户协议
                    </div>
                    <div class="reglogin">
                        <button name="login" type="submit">登入</button>
                    </div>
                    <span><a href="">忘记密码</a></span>
                </div>

            </div>
            </div>
    </form>
</div>
<script>
    const form = document.querySelector('form')
    const agree = document.querySelector('[name=agree]')
    const uname = document.querySelector('[name=uname]')
    const login = document.querySelector('[name=login]')
    const regist = document.querySelector('[name=regist]')
    // 提交表单事件 登入跳转
    form.addEventListener('submit', function (e) {
        if (!agree.checked) {
            return alert('请勾选用户协议')
        }
    })
</script>

</body>

</html>
