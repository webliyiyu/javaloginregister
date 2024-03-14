package com.buercorp.wangyu.listener;

import com.buercorp.wangyu.pojo.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 初始化计数的监听器
 */
@WebListener
public class InitCountServletContextListener implements ServletContextListener {
    //监听到ServletContext创建就会执行
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化number,然后存进ServletContext
        int number = 0;
        sce.getServletContext().setAttribute("number",number);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
