package org.springframework.myTest;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/8/6
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
