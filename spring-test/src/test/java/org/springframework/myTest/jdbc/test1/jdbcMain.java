package org.springframework.myTest.jdbc.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("myTestResources/jdbc/test1/applicationContext_jdbc.xml");


	}
}
