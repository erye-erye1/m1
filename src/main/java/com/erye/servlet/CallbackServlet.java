package com.erye.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.service.CallbackListenerInter;
import com.erye.service.CallbackServiceInter;

public class CallbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 获取服务对象
		CallbackServiceInter callbackService = ioc.getBean("callbackService", CallbackServiceInter.class);
		
		callbackService.addListerner("abc", new CallbackListenerInter() {
			public String changed(String msg) {
				return "callback = " + msg;
			}
		});
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
