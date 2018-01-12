package com.erye.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.alibaba.dubbo.rpc.service.GenericService;

/**
 * 测试  泛化调用。消费方没有接口类，但是也可以调用服务方的方法
 */
public class GenericServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 获取ioc容器
		ApplicationContext ioc = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
		
		// 将服务方的接口对象泛型化
		GenericService genericService = (GenericService) ioc.getBean("genericService");
		
		// 调用服务方的方法
		// 参数说明：$invoke(String arg0, String[] arg1, Object[] arg2) 
		// arg0：远程方法的方法名；arg1：参数类型；arg2：具体的参数
		Object result = genericService.$invoke("generic", new String[]{"java.lang.String"}, new Object[]{"erye"});
		
		System.out.println(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
