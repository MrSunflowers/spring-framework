package org.springframework.myTest.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
@Service
@Aspect
public class TransactionManager {
	//https://www.cnblogs.com/joy99/p/10941543.html
	//https://blog.csdn.net/f641385712/article/details/83543270
	//定义切入点，切入点名称为方法名称
	@Pointcut("@target(org.springframework.myTest.aop.demo.A1)")
	public void pointcut(){}

	@Before("pointcut()")
	public void begin(){
		System.out.println("开启事务");
	}

	public void commit(){
		System.out.println("事务提交");
	}

	public void rollBack(Exception e){
		System.out.println("事务回滚" + e);
	}

	public void close(){
		System.out.println("释放资源");
	}

	public Object around (ProceedingJoinPoint proceedingJoinPoint){
		Object ret = null;
		begin();
		try {
			ret = proceedingJoinPoint.proceed();
			commit();
		} catch (Throwable throwable) {
			rollBack(new Exception(throwable.getMessage()));
			throwable.printStackTrace();
		}finally {
			close();
		}
		return ret;
	}
}
