package org.springframework.myTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.myTest.CreateBeanTest.CreateBeanTestBean;
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
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		earlySingletonTest(beanFactory);
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/applicationContext.xml");
		UserA userA = (UserA)context.getBean("userA");
		UserB userB = (UserB)context.getBean("userB");*/
		//System.out.println(userA.getUserB().equals(userB));
		//System.out.println(userB.getUserA().equals(userA));
		/*AnnotationConfigApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext("org/springframework/myTest");
		UserA userA = (UserA)classPathXmlApplicationContext.getBean("userA");
		UserB userB = (UserB)classPathXmlApplicationContext.getBean("userB");
		System.out.println(userA.getUserB().equals(userB));
		System.out.println(userB.getUserA().equals(userA));*/


	}
	/**
	 * description: 构造器测试 <br>
	 * version: 1.0 <br>
	 * date: 2021/9/6 15:29 <br>
	 * author: lyk <br>
	 */
	private static void CreateBeanTest(XmlBeanFactory beanFactory) {
		CreateBeanTestBean createBeanTestBean = (CreateBeanTestBean) beanFactory.getBean("createBeanTestBean");
		System.out.println(createBeanTestBean);
	}

	/**
	 * description: 循环依赖测试 <br>
	 * version: 1.0 <br>
	 * date: 2021/9/6 15:30 <br>
	 * author: lyk <br>
	 */
	private static void earlySingletonTest(XmlBeanFactory beanFactory) {
		UserA userA = (UserA)beanFactory.getBean("userA");
		UserB userB = (UserB)beanFactory.getBean("userB");
		System.out.println(userA.getUserB().equals(userB));
		System.out.println(userB.getUserA().equals(userA));
	}

	private static void InstanceSupplierTest(XmlBeanFactory beanFactory) {
		GenericBeanDefinition genericBeanDefinition = (GenericBeanDefinition) beanFactory.getBeanDefinition("user");
		genericBeanDefinition.setInstanceSupplier(Main::getUser);
		User user = (User)beanFactory.getBean("user");
		System.out.println(user.getName());
	}

	private static void FactoryBeanTest(XmlBeanFactory beanFactory) {
		Car car = (Car) beanFactory.getBean("car");
		Color color = car.getColor();
		if(color instanceof Red){
			System.out.println("red");
		}
		if(color instanceof Blue){
			System.out.println("Blue");
		}
	}


	public static User getUser(){
		return new User("zhangsan");
	}



}
