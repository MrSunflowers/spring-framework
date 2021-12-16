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
import org.springframework.core.convert.ConversionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.myTest.CreateBeanTest.CreateBeanTestBean;
import org.springframework.myTest.MyBeanFactoryPostProcessor.MyBeanFactoryPostProcessor;
import org.springframework.myTest.eventListener.TestEvent;
import org.springframework.myTest.eventListener.TestListener;
import org.springframework.myTest.factoryBeanTest.Blue;
import org.springframework.myTest.factoryBeanTest.Car;
import org.springframework.myTest.factoryBeanTest.Color;
import org.springframework.myTest.factoryBeanTest.Red;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;

import java.util.Date;
import java.util.Locale;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("myTestResources/applicationContext.xml");
		ConversionService conversionService = context.getBeanFactory().getConversionService();
		Date convert = conversionService.convert("2020-12-10", Date.class);
		System.out.println(convert);
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
