package org.springframework.myTest.aop.demo;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {

	/**
	 * 参考 https://www.cnblogs.com/joy99/p/10941543.html
	 * @param o 表示增强的对象
	 * @param method 需要增强的方法
	 * @param objects 要被拦截方法的参数
	 * @param methodProxy 表示要触发父类的方法对象
	 * @return java.lang.Object
	 */
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
