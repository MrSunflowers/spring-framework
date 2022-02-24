package org.springframework.myTest.jdbc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class jdbcMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/applicationContext_jdbc.xml");

	}
}
