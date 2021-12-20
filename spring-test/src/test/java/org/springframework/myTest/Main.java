package org.springframework.myTest;

import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.myTest.CreateBeanTest.CreateBeanTestBean;
import org.springframework.myTest.aop.demo.*;
import org.springframework.myTest.factoryBeanTest.Blue;
import org.springframework.myTest.factoryBeanTest.Car;
import org.springframework.myTest.factoryBeanTest.Color;
import org.springframework.myTest.factoryBeanTest.Red;
import org.springframework.cglib.proxy.Enhancer;
import java.lang.reflect.Proxy;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class Main {

	public static void main(String[] args) {
		/*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/applicationContext_AOP.xml");
		TestService testService = (TestService) context.getBean("testServiceStaticProxy");
		testService.save();*/
		/*TestService testService = (TestService)Proxy.newProxyInstance(TestServiceImpl.class.getClassLoader(), new Class[]{TestService.class}, new MyInvocationHandler(new TestServiceImpl()));
		testService.save();*/

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(TestServiceImpl.class);
		enhancer.setCallback(new MyMethodInterceptor());
		TestService testService = (TestService)enhancer.create();
		testService.save();

		/*System.out.println(testService.getClass().getName());
		Class<?>[] interfaces = testService.getClass().getInterfaces();
		for (Class<?> c : interfaces) {
			System.out.println("interfaces:"+c.getName());
		}
		printSuperclass(testService.getClass());
		System.out.println(testService instanceof Proxy);*/
	}

	private static void printSuperclass(Class<?> clz){
		Class<?> superclass = clz.getSuperclass();
		if(superclass!=null){
			System.out.println("superclass:"+superclass.getName());
			printSuperclass(superclass.getSuperclass());
		}
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
		AutowiredAnnotationBeanPostProcessor autowiredAnnotationBeanPostProcessor = new AutowiredAnnotationBeanPostProcessor();
		autowiredAnnotationBeanPostProcessor.setBeanFactory(beanFactory);
		beanFactory.addBeanPostProcessor(autowiredAnnotationBeanPostProcessor);
		/*BeanDefinition userA1 = beanFactory.getBeanDefinition("userA");
		if(userA1 instanceof GenericBeanDefinition){
			((GenericBeanDefinition)userA1).setDependencyCheck(AbstractBeanDefinition.DEPENDENCY_CHECK_ALL);
		}*/
		UserA userA = (UserA)beanFactory.getBean("userA");
		UserB userB = (UserB)beanFactory.getBean("userB");
		//System.out.println(userB.getUserA().equals(userA));
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





}
