package com.erye.service;

import com.erye.notice.LoginNoticeInter;

public class LoginNotice implements LoginNoticeInter {

	public String onreturn(String result, String param1, String param2) {
		System.out.println("正常调用方法，返回结果为 result = " + result);
		System.out.println("输入的参数为 = " + param1 + "," + param2);
		return result;
	}

	public void onthrow(Throwable e, String param1, String param2) {
		System.out.println("调用方法出现异常，e = " + e);
		System.out.println("输入的参数为 = " + param1 + "," + param2);
	}

}
