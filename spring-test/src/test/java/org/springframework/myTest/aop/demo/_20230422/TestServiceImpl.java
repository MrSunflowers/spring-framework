package org.springframework.myTest.aop.demo._20230422;


import org.springframework.myTest.aop.demo.A1;
import org.springframework.stereotype.Service;

@Service
@A1
public class TestServiceImpl implements TestService {

	public void save() throws Exception {
		System.out.println("保存数据到数据库");
	}


}
