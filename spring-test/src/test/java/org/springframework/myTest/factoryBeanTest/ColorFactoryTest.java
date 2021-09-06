package org.springframework.myTest.factoryBeanTest;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/9/6
 */
public class ColorFactoryTest {
	public Color getInstance(){
		return new Blue();
	}
}
