package org.springframework.myTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.myTest.factoryBeanTest.Blue;
import org.springframework.myTest.factoryBeanTest.Car;
import org.springframework.myTest.factoryBeanTest.Color;
import org.springframework.myTest.factoryBeanTest.Red;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class Main {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("myTestResources/applicationContext.xml");
		BeanFactory beanFactory = new XmlBeanFactory(resource);
		/*Car car = (Car) beanFactory.getBean("car");


		Color color = car.getColor();
		if(color instanceof Red){
			System.out.println("red");
		}
		if(color instanceof Blue){
			System.out.println("Blue");
		}*/

		UserA userA = (UserA)beanFactory.getBean("userA");
		UserB userB = (UserB)beanFactory.getBean("userB");
		System.out.println(userA.getUserB().equals(userB));
		System.out.println(userB.getUserA().equals(userA));
	}
}
