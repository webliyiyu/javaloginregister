package com.buercorp.wangyu.servlet.user;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.impl.UserSericeimpl;
import com.buercorp.wangyu.utils.DruidUtil;
import com.mysql.cj.Session;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;

/**
 * 注销账户
 */

@WebServlet("/logout")
public class LogoutUser extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        // 保证解码和编码一致
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        User user = (User) request.getSession().getAttribute("user");

        int userId = user.getId();
        System.out.println("userId "+userId);
        UserSericeimpl userService = new UserSericeimpl();
        userService.deleteUser(userId);

        response.getWriter().write("<script>alert('注销成功'); window.location.href='login.jsp';");
        request.getSession().invalidate();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}
