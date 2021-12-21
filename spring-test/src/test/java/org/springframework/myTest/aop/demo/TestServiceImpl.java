package org.springframework.myTest.aop.demo;


public class TestServiceImpl implements TestService{
	@Override
	public void save() throws Exception {
		System.out.println("保存数据到数据库");
		//throw new Exception("异常");
	}
}
