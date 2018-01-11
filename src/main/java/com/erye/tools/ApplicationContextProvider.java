package com.erye.tools;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {

	private static ApplicationContext ioc = null;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ioc = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return ioc;
	}

}
