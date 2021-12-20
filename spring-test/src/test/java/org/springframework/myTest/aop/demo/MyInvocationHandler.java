package org.springframework.myTest.aop.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

	private Object object;

	public MyInvocationHandler(Object object) {
		this.object = object;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			System.out.println("开启事务");
			result = method.invoke(object,args);
			System.out.println("事务提交");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("事务回滚");
		}
		return result;
	}
}
