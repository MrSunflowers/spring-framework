package org.springframework.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/6/21
 */
public class UserA {
	private String name;
	private int age;
	private int email;
	private UserB userB;

	private UserA(UserB userB) {
		this.userB = userB;
	}


	public String getName() {
		return name;
	}
	@Value("asd")
	public void setName(String name) {
		System.out.println(name);
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

	public UserB getUserB() {
		return userB;
	}

	public void setUserB(UserB userB) {
		this.userB = userB;
	}

	@PostConstruct
	public void initMethod(int q){
		System.out.println("initMethod");
	}
	@PreDestroy
	public void destroyMethod(int q){
		System.out.println("destroyMethod");
	}


}
