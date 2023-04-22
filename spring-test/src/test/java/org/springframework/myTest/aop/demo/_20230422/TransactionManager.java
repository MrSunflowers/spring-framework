package org.springframework.myTest.aop.demo._20230422;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

public class TransactionManager {

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

}
