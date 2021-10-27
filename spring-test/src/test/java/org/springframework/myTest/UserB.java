package org.springframework.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.myTest.factoryBeanTest.TestUser;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class UserB implements TestUser {
	private String name;
	private int age;
	private int email;
	private UserA userA;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public UserA getUserA() {
		return userA;
	}

	public void setUserA(UserA userA) {
		this.userA = userA;
	}

}
