package com.erye.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.dubbo.rpc.service.EchoService;
import com.erye.service.EchoServiceInter;

/**
 * 测试  测试回声测试
 */
public class EchoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 获取用来回声测试的服务对象
		EchoServiceInter echoServiceInter = ioc.getBean("echoService", EchoServiceInter.class);
		
		// 将服务对象强转为EchoService类的对象
		EchoService echoService = (EchoService)echoServiceInter;
		
		// 回声测试可用性
		Object result = echoService.$echo("可用");
		System.out.println("回声测试的结果，  result = " + result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
