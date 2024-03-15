package com.buercorp.wangyu.servlet.user;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 退出登入
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
        // 销毁session
        request.getSession().invalidate();
        try {
            response.getWriter().write("logout");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
