package org.springframework.myTest.aop.demo;


import org.springframework.aop.framework.AopContext;

public class TestServiceImpl {


	public void save() throws Exception {
		System.out.println("保存数据到数据库");
		//this.update(); 此处的 this 指向目标对象，因此无法实施切面中的增强
		((TestServiceImpl)AopContext.currentProxy()).update();
	}
	public void update(){
		System.out.println("更新数据到数据库");
	}

}
