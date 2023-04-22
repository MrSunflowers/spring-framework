package org.springframework.myTest.aop.demo._20230422;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/2/24
 */
public class aopmain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/20230422/applicationContext_AOP.xml");
		TestService testServiceImpl = (TestService) context.getBean("testServiceImpl");
		testServiceImpl.save();
	}

}
