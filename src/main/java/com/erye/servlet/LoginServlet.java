package com.erye.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.service.LoginServiceInter;
import com.google.gson.Gson;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@SuppressWarnings("rawtypes")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 获取登录的服务对象
		LoginServiceInter loginService = ioc.getBean("loginService", LoginServiceInter.class);
		
		// 获取输入的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// 调用服务
		String json = loginService.login(username, password);
		Gson gson = new Gson();
		Map map = gson.fromJson(json, Map.class);
		
		// 获取登录的结果
		boolean flag = (Boolean) map.get("flag");
		String result = (String) map.get("result");
		
		// 根据登录的结果选择跳转的页面
		if(flag) {
			request.setAttribute("msg", result);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", result);
			request.getRequestDispatcher("/page/login/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
