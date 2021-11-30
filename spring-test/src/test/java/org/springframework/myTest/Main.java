package org.springframework.myTest;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanExpressionContext;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.expression.StandardBeanExpressionResolver;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.myTest.CreateBeanTest.CreateBeanTestBean;
import org.springframework.myTest.MyBeanFactoryPostProcessor.MyBeanFactoryPostProcessor;
import org.springframework.myTest.factoryBeanTest.Blue;
import org.springframework.myTest.factoryBeanTest.Car;
import org.springframework.myTest.factoryBeanTest.Color;
import org.springframework.myTest.factoryBeanTest.Red;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class Main {

	public static void main(String[] args) {
		/*Resource resource = new ClassPathResource("myTestResources/applicationContext.xml");
		XmlBeanFactory beanFactory = new XmlBeanFactory(resource);
		earlySingletonTest(beanFactory);*/
		/*AwareTestBean awareTestBean = (AwareTestBean)beanFactory.getBean("awareTestBean");
		System.out.println(awareTestBean);*/

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/applicationContext.xml");
		UserA userA = (UserA)context.getBean("userA");
		System.out.println(userA.getDate());
		System.out.println(userA.getName());
		//System.out.println(userA.getUserB().equals(userB));
		//System.out.println(userB.getUserA().equals(userA));
		/*AnnotationConfigApplicationContext classPathXmlApplicationContext = new AnnotationConfigApplicationContext("org/springframework/myTest");
		UserA userA = (UserA)classPathXmlApplicationContext.getBean("userA");
		UserB userB = (UserB)classPathXmlApplicationContext.getBean("userB");
		System.out.println(userA.getUserB().equals(userB));
		System.out.println(userB.getUserA().equals(userA));*/

		//创建ExpressionParser解析表达式
		//ExpressionParser parser = new SpelExpressionParser();
		//表达式放置
		//Expression exp = parser.parseExpression("userA");
		//执行表达式，默认容器是spring本身的容器：ApplicationContext
		//Object value = exp.getValue();
		//System.out.println(value);

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
