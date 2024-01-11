package org.springframework.myTest.jdbc.test1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Objects;

public class jdbcMain {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("myTestResources/jdbc/test1/applicationContext_jdbc.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		Connection connection = dataSource.getConnection();
		Objects.requireNonNull(connection);
		connection.close();
	}
}
