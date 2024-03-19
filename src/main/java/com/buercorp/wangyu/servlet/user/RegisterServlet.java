package com.buercorp.wangyu.servlet.user;

import com.buercorp.wangyu.dao.impl.UserDaolmpl;
import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.service.UserService;
import com.buercorp.wangyu.service.impl.UserSericeimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserSericeimpl userSerice = new UserSericeimpl();
    private UserDaolmpl userDao = new UserDaolmpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保证解码和编码一致
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //2. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("接收到的参数: ");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + value);
            }
        }
        //3. 使用BeanUtils 将parameterMap中的数据，存储到User对象中
        User user = new User();
        try {
            BeanUtils.copyProperties(parameterMap, user);
            //设置默认的status为"0"
            user.setStatus("0");
//            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        // 如果注册成功，跳转至 index.jsp
        boolean b = userSerice.insertUser(user);
        System.out.println("b: " + b);
        if (!b) {
            System.out.println("注册失败");
            response.getWriter().write("<script>alert('注册失败，数据库插入失败'); window.location.href='register.jsp';</script>");
        }
        System.out.println("注册成功");
        response.getWriter().write("<script>alert('注册成功'); window.location.href='login.jsp';</script>");
//        response.sendRedirect("logio.jsp");

    }
}
