package com.buercorp.wangyu.servlet.user;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 保证解码和编码一致
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //2. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        User user = new User();
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

//            for (String value : entry.getValue()) {
//                System.out.println(entry.getKey() + ": " + value);
//            }
        }
        // 使用BeanUtils 将parameterMap中的数据，存储到User对象中
//        user = new User(user.getId(), user.getNickname(), user.getAddress(), user.getGender(), user.getEmail(), user.getPassword(), user.getUsername()); // null
        // 设置默认的status为"0"

        try {
            // 获取当前登录用户信息
            User object = (User) request.getSession().getAttribute("user");
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "update user set username=?, password=?,  address=?, nickname=?, gender=?, email=? where username = ?";
            queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), object.getUsername());

//            Integer userId = Integer.valueOf(user.getId());
//            System.out.println("userId:::::" + userId);
//            User newUser = new User(userId, user.getUsername(), user.getPassword(), user.getAddress(), user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
//            HttpServlet session = (HttpServlet) request.getSession();
//            request.setAttribute("user", user);

//            session.setAttribute("user", newUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("修改成功");

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}



