package org.springframework.myTest.TestLifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.SmartLifecycle;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2021/12/17
 */
public class TestLifecycle implements Lifecycle {

	private boolean running = false;

	@Override
	public void start() {
		this.running = true;
		System.out.println("TestLifecycle is start");
	}

	@Override
	public void stop() {
		this.running = false;
		System.out.println("TestLifecycle is stop");
	}

	@Override
	public boolean isRunning() {
		return this.running;
	}

}
