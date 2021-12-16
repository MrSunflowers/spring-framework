package org.springframework.myTest.eventListener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

public class TestListener implements ApplicationListener<TestEvent> {
	@Override
	public void onApplicationEvent(TestEvent event) {
		event.print();
	}
}
