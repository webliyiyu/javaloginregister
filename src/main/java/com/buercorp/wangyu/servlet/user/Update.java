package com.buercorp.wangyu.servlet.user;

import com.buercorp.wangyu.pojo.User;
import com.buercorp.wangyu.utils.DruidUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

@WebServlet("/update")
public class Update extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        // 保证解码和编码一致
        //解决请求参数的中文乱码
        request.setCharacterEncoding("UTF-8");
        //解决响应中文乱码
        response.setContentType("text/html;charset=utf-8");

        //2. 获取所有的请求参数
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println("修改接收到的参数: ");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            for (String value : entry.getValue()) {
                System.out.println(entry.getKey() + ": " + value);
            }
        }
        // 使用BeanUtils 将parameterMap中的数据，存储到User对象中
        User user = new User();
        // 设置默认的status为"0"
        user.setStatus("0");
        try {
            BeanUtils.populate(user, parameterMap);

            Connection connection = DruidUtil.getDataSource().getConnection();
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "update user set username=?, password=?, nickname=?, gender=?, address=?,email=? ";
            queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());

            System.out.println("username:::::" + user.getUsername());
            System.out.println("password:::::" + user.getPassword());

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        System.out.println("修改成功");


    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        doPost(request, response);
    }
}
