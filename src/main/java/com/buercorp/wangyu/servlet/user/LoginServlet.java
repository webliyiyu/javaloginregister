package com.buercorp.wangyu.login;


import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/login")
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

        //3. 连接数据库校验用户名和密码，也就是执行查询的SQL语句
        QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
        String sql = "select * from user where username=?";
        //执行查询，查询一条数据，封装到User中
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("查询到的user数据: " + user);


        if (user == null) {
            response.getWriter().write("用户不存在");
        }
        if (!(user.getPassword().equals(password))){
            response.getWriter().write("密码错误");
        }

        response.sendRedirect("index.html");

    }
}
