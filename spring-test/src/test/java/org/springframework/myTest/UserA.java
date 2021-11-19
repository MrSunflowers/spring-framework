package org.springframework.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.myTest.testType.TestType;
import org.springframework.myTest.testType.TestType1;
import org.springframework.myTest.testType.TestType2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class UserA {
	private String name;
	private int age;
	private int email;

	private UserB userB;

	//private List<TestType> testType1;

	/*public List<TestType> getTestType1() {
		return testType1;
	}

	public void setTestType1(List<TestType> testType1) {
		this.testType1 = testType1;
	}*/


	public UserB getUserB() {
		return userB;
	}
	@Value("#{userB}")
	public void setUserB(UserB userB) {
		this.userB = userB;
	}

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

}
