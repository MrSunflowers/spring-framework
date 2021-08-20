package org.springframework.myTest.factoryBeanTest;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/8/12
 */
public class ColorFactory implements FactoryBean<Color> {
	@Override
	public Color getObject() throws Exception {
		return new Red();
	}

	@Override
	public Class<?> getObjectType() {
		return Red.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}
}
