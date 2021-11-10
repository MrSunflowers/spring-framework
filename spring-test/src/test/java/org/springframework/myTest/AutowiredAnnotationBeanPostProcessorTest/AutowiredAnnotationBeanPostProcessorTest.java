package org.springframework.myTest.AutowiredAnnotationBeanPostProcessorTest;

import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/11/10
 */
public class AutowiredAnnotationBeanPostProcessorTest extends AutowiredAnnotationBeanPostProcessor {
	public AutowiredAnnotationBeanPostProcessorTest(){
		super();
	}

	@Override
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
		super.postProcessProperties(pvs, bean, beanName);
		return null;
	}
}
