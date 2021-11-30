package org.springframework.myTest.MyBeanFactoryPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.Iterator;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private String str = "23";

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		Iterator<String> beanNamesIterator = beanFactory.getBeanNamesIterator();
		while(beanNamesIterator.hasNext()){
			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanNamesIterator.next());
			StringValueResolver stringValueResolver = strVal -> {
				if(strVal.contains(str)){
					return strVal.replaceAll(str,"**");
				}
				return strVal;
			};
			BeanDefinitionVisitor beanDefinitionVisitor = new BeanDefinitionVisitor(stringValueResolver);
			beanDefinitionVisitor.visitBeanDefinition(beanDefinition);
		}

	}
}
