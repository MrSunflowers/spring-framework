package org.springframework.myTest.aop.demo;


import org.springframework.aop.framework.AopContext;

public class TestServiceImpl {

	public void save() throws Exception {
		System.out.println("保存数据到数据库");
	}
}
