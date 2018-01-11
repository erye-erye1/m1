package com.erye.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.service.FuckYouServiceInter;

/**
 * 测试  分组聚合
 */
public class MergerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 获取合并练习的对象
		FuckYouServiceInter mergerService = ioc.getBean("mergerService", FuckYouServiceInter.class);
		String[] str1s = mergerService.fuckyou("hello, how are you");
		String[] str2s = mergerService.fuckyou("cao ni da ye de!");
		
		System.out.println("str1s = " + Arrays.asList(str1s));
		System.out.println("str2s = " + Arrays.asList(str2s));
		
		request.setAttribute("msg", str1s[0] + " >> " + str2s[0]);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
