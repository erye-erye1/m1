package com.erye.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.service.RegistServiceInter;

public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		RegistServiceInter registService = ioc.getBean("registService", RegistServiceInter.class);
		
		// 获取输入的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		registService.regist(username, password);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
