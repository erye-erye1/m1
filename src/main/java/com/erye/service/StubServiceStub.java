package com.erye.service;

import com.erye.entity.Computer;

/**
 * 本地存根
 */
public class StubServiceStub implements StubServiceInter {

	//必须定义这个接口，以便接收dubbo在调用远程服务生成的服务代理类
	private StubServiceInter stubServiceInter;
	
	//这个构造函数必须要提供，dubbo框架会在消费者这一方调用这个方法
	public StubServiceStub(StubServiceInter stub) {
		this.stubServiceInter = stub;
	}
	
	public Computer getComputer(Integer id) {
		
		Computer computer = null;
		if(id == 1) {
			computer = this.stubServiceInter.getComputer(id);
		}else {
			computer = new Computer();
			computer.setId(id);
			computer.setName("Lenovo");
			System.out.println("调用了本地的stubServiceStub......");
		}
		
		return computer;
	}

}
