package org.springframework.myTest.aop.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class TestServiceStaticProxy implements TestService {

	@Autowired
	private TestService testServiceImpl;

	@Override
	public void save() {
		try {
			System.out.println("开启事务");
			this.testServiceImpl.save();
			System.out.println("事务提交");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("事务回滚");
		}
	}
}
