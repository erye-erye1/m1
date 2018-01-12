package com.erye.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.service.AsyncServiceInter;

/**
 * 测试  异步调用远程服务
 */
public class AsyncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 获取服务的对象
		AsyncServiceInter asyncService = ioc.getBean("asyncService", AsyncServiceInter.class);
		
		String result = asyncService.async("erye");
		System.out.println("异步调用的  result = " + result);
		
		result = asyncService.async("张三");
		System.out.println("异步调用的  result = " + result);
				
		result = asyncService.async("李四");
		
		System.out.println("异步调用的  result = " + result);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
