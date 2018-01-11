package com.erye.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.erye.entity.Consumer;
import com.erye.service.ValidationServiceInter;

/**
 * 测试  验证
 */
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器，并获取校验使用的对象
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		ValidationServiceInter validationService = ioc.getBean("validationService", ValidationServiceInter.class);
		
		// 获取页面过来的数据
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		String loginDateStr = request.getParameter("loginDate");
		String expiryDateStr = request.getParameter("expiryDate");
		
		// 转换日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date loginDate = null;
		Date expiryDate = null;
		try {
			if(null != loginDateStr && !"".equals(loginDateStr)) {
				loginDate = sdf.parse(loginDateStr);
			}
			if(null != expiryDateStr && !"".equals(expiryDateStr)) {
				expiryDate = sdf.parse(expiryDateStr);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// 转换年龄格式
		Integer age = 0;
		if(null != ageStr && !"".equals(ageStr)) {
			try {
				age = Integer.parseInt(ageStr);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 将获取的数据封装进Consumer对象中
		Consumer consumer = null;
		try {
			consumer = new Consumer(username, password, email, age, loginDate, expiryDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 调用save(@NotNull Consumer consumer)方法，测试参数不允许为null
		validationService.save(consumer);
		
		// 跳转到成功页面
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
