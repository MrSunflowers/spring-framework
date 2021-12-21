package org.springframework.myTest.aop.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class TransactionManager {
	//定义切入点，切入点名称为方法名称
	@Pointcut("execution(* org.springframework.myTest.aop.demo.*Service*.*(..))")
	public void pointcut(){
	}

	@Before("pointcut()")
	public void begin(){
		System.out.println("开启事务");
	}

	@AfterReturning("pointcut()")
	public void commit(){
		System.out.println("事务提交");
	}

	@AfterThrowing(value = "pointcut()",throwing = "e")
	public void rollBack(Exception e){
		System.out.println("事务回滚" + e);
	}

	@After("pointcut()")
	public void close(){
		System.out.println("释放资源");
	}

	@Around("pointcut()")
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
