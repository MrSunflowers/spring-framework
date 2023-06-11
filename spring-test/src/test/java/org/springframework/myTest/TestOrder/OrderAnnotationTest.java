package org.springframework.myTest.TestOrder;

import org.springframework.core.OrderComparator;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderAnnotationTest {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		List<Object> orderList = new ArrayList<>(3);
		orderList.add(a);
		orderList.add(b);
		orderList.add(c);
		orderList.sort(OrderComparator.INSTANCE); // [B, A, C]
		orderList.sort(AnnotationAwareOrderComparator.INSTANCE); //[B, A, C]
		System.out.println(orderList);
	}

	@Order(0)
	static class A implements PriorityOrdered {
		@Override
		public String toString() {
			return "A";
		}

		@Override
		public int getOrder() {
			return 0;
		}
	}

	@Order(-1)
	static class B implements PriorityOrdered{
		@Override
		public String toString() {
			return "B";
		}

		@Override
		public int getOrder() {
			return -1;
		}
	}

	@Order(20)
	static class C implements PriorityOrdered{
		@Override
		public String toString() {
			return "C";
		}

		@Override
		public int getOrder() {
			return 2;
		}
	}
}
