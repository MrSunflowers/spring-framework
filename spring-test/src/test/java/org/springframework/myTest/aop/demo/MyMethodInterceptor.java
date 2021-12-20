package org.springframework.myTest.aop.demo;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		try {
			System.out.println("开启事务");
			result = methodProxy.invokeSuper(o,objects);
			System.out.println("事务提交");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("事务回滚");
		}
		return result;
	}
}
