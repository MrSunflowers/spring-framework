package org.springframework.myTest;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/8/6
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return UserA.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		String name = element.getAttribute("name");
		int age = Integer.valueOf(element.getAttribute("age"));
		String email = element.getAttribute("email");
		builder.addPropertyValue("name",name);
		builder.addPropertyValue("age",age);
		builder.addPropertyValue("email",email);
	}
}
