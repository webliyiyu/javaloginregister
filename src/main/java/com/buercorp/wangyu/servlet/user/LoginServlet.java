package com.buercorp.wangyu.servlet.user;


import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.impl.UserSericeimpl;
import com.buercorp.wangyu.utils.DruidUtil;
import com.mysql.cj.Session;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * 登录
 */
@WebServlet("/login")
// @Controller("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1. 解决乱码
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //2. 获取请求参数username和password
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("登录用户名: " + username + ", 密码:" + password);

        UserSericeimpl userSericeimpl = new UserSericeimpl();
        User user = userSericeimpl.getUser(username, password);

        if (user == null) {
            System.out.println("用户不存在");
            response.getWriter().write("<script>alert('用户不存在'); window.location.href='login.jsp';</script>");
        }
        if (!(user.getPassword().equals(password))) {
            System.out.println("密码错误");
            response.getWriter().write("<script>alert('密码错误'); window.location.href='login.jsp';</script>");
        }

        request.getSession().setAttribute("user", user);
        request.getSession().setAttribute("req", request);


        response.sendRedirect("index.jsp");
    }
}
