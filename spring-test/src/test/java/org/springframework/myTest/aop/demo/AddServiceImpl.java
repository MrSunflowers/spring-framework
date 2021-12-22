package org.springframework.myTest.aop.demo;

public class AddServiceImpl implements AddService{
	@Override
	public void update() {
		System.out.println("更新数据库");
	}
}
