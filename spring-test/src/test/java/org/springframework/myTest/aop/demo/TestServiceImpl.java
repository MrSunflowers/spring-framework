package org.springframework.myTest.aop.demo;


import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
@A1
public class TestServiceImpl implements TestService {

	public void save() throws Exception {
		System.out.println("保存数据到数据库");
		//this.update(); 此处的 this 指向目标对象，因此无法实施切面中的增强
		//((TestServiceImpl)AopContext.currentProxy()).update();
		//throw new Exception();
	}

	/*@Override
	public void AsaveBb() throws Exception {
		System.out.println("save2");
	}

	public void update(){
		System.out.println("更新数据到数据库");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
	}

	public void myInit(){
		System.out.println("myInit");
	}*/

}
