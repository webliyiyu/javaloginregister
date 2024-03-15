package com.buercorp.wangyu.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 基于session计数的监听器
 */
@WebListener
public class CountSessionListener implements HttpSessionListener {
    // session创建,就会执行
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession(); // 获取HttpSession域对象

        ServletContext servletContext = session.getServletContext(); // 获取 ServletContext
        int number = (int) servletContext.getAttribute("number"); // 增加number值
        number++;
        // 绑定到ServletContext对象上，以便在其他地方通过getAttribute方法获取该属性的值
        servletContext.setAttribute("number", number);
        System.out.println("number:" + number);
        System.out.println("有人上线了");
    }

    // session销毁,就会执行
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession(); // 获取HttpSession域对象

        ServletContext servletContext = session.getServletContext(); // 获取 ServletContext
        int number = (int) servletContext.getAttribute("number"); // 减少number值
        number--;
        servletContext.setAttribute("number", number);
        System.out.println("number:" + number);
        System.out.println("有人下线了....");
    }
}