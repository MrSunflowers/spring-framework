package org.springframework.myTest.eventListener;

import org.springframework.context.ApplicationEvent;


public class TestEvent extends ApplicationEvent {

	private static final long serialVersionUID = 7099057708183571930L;

	private String msg;

	public TestEvent(Object source) {
		super(source);
	}

	public TestEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public void print(){
		System.out.println(msg);
	}

}
