package org.springframework.myTest.aop.demo;

public class TestServiceImpl implements TestService {
	@Override
	public void save() {
		System.out.println("保存数据到数据库");
	}
}
