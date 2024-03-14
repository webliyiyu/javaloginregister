package com.buercorp.wangyu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 定义解决中文乱码请求的过滤器
 */
@WebFilter(urlPatterns = "/*") // 1. 使用 /* 拦截所有请求
public class PostFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)  {
        // 拦截请求，设置中文编码格式，解决中文乱码问题
        // 1. 获取请求 request
        HttpServletRequest request = (HttpServletRequest) req;
        // 2. 判断请求的方法类型
        String method = request.getMethod();
        if ("POST".equalsIgnoreCase(method)) {
            //3. 当请求的方法为 POST，则设置编码格式
            //解决请求参数的中文乱码
            try {
                request.setCharacterEncoding("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }

        // 4. 打印 req 和 request
        System.out.println("req:" + req);
        System.out.println("request:" + request);

        // 放行
        try {
            try {
                chain.doFilter(req, resp);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {

    }

}
