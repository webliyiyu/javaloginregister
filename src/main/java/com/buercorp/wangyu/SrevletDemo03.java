package com.buercorp.wangyu;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * 实现Servlet
 * 1.创建普通Java类
 * 2.实现Servlet的规范 继承HttpServlet类  必须重写GET  POST
 * 3.重写servlet
 * 4.设置注解 访问路径  / 不要忘记写
 * @author liyiyu
 */
@WebServlet("/ser")
public class SrevletDemo03 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 控制台打印
        System.out.println("Hello Servlet");
        // 通过流输出数据到浏览器
        resp.getWriter().write("Hello Servlet");
    }
}
