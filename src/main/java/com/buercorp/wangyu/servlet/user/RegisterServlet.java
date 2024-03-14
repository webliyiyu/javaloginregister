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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
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
        //设置默认的status为"0"
        user.setStatus("0");

        int row = 0;
        // 使用 BeanUtils.populate 将接收到的参数保存到 user 对象中
        try {
            BeanUtils.populate(user, parameterMap);
            /**
             * 使用DBUtils将用户信息存储到数据库
             * 这里需要mysql驱动、druid、dbutils的jar包
             * 使用了BeanUtils和DBUtils两个工具类来简化数据处理和数据库操作的过程。
             * 在存储数据到数据库时，使用了QueryRunner类和Druid数据源来进行数据库操作
             */
            QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
            String sql = "insert into user values (null,?,?,?,?,?,?,?)";
            row = queryRunner.update(sql, user.getUsername(), user.getPassword(), user.getAddress(),
                    user.getNickname(), user.getGender(), user.getEmail(), user.getStatus());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            response.getWriter().write("SQL异常信息如下:" + e.getMessage());
            throw new RuntimeException(e);
        }
        // 如果注册成功，跳转至 index.html
        if (row != 1) {
            System.out.println("注册失败");
            response.getWriter().write("注册失败，数据库插入失败");
        } else {
            System.out.println("注册成功");
            response.getWriter().write("注册成功");
            response.sendRedirect("index.html");
        }
    }
}
