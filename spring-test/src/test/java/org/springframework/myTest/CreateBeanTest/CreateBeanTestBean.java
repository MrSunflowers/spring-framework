package org.springframework.myTest.CreateBeanTest;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/9/2
 */
public class CreateBeanTestBean {
	private String name;
	private int age;

	public CreateBeanTestBean(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "CreateBeanTestBean{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}
