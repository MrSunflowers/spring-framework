package org.springframework.myTest;

public class User {
	private String name;

	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void init() {
		System.out.println("user 初始化.....");
	}
}
