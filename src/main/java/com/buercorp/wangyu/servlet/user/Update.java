package com.buercorp.wangyu.servlet.user;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.pojo.UserInfo;
import com.buercorp.wangyu.service.impl.UserSericeimpl;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        // 保证解码和编码一致
        // 解决请求参数的中文乱码
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        // 解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        // 获取用户信息
        User user = (User) request.getSession().getAttribute("user");
        int id = user.getId();

        //2. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("接收到的参数: ");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + value);
            }
        }
        //设置默认的status为"0"
        user.setStatus("0");
        // 获取所有的请求参数
        /*Map<String, String[]> parameterMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            switch (key) {
                case "username":
                    user.setUsername(values[0]);
                case "password":
                    user.setPassword(values[0]);
                case "address":
                    user.setAddress(values[0]);
                case "nickname":
                    user.setNickname(values[0]);
                case "gender":
                    user.setGender(values[0]);
                case "email":
                    user.setEmail(values[0]);
                default:
                    user.setStatus("0");
                    break;
            }

        }*/

        try {
            // 将请求参数赋值给user
            BeanUtils.populate(user, parameterMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        // 获取当前登录用户信息
        System.out.println("当前登录用户信息：" + user);
        UserInfo userInfo = new UserInfo(user.getUsername(), user.getPassword(), user.getAddress(), user.getNickname(), user.getGender(), user.getEmail());
        // 数据只在当前请求的生命周期内有效
        request.setAttribute("userInfo", userInfo);

        System.out.println("当前更新用户信息：" + userInfo);

        UserSericeimpl userSericeimpl = new UserSericeimpl();
        boolean b = userSericeimpl.updateUser(user, id);
        request.getSession().setAttribute("user", user);
        System.out.println("更新用户信息：" + b);
        if (!b) {
            try {
                response.getWriter().write("<script>alert('更新失败'); window.location.href='update.jsp';");
                System.out.println("修改失败");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}