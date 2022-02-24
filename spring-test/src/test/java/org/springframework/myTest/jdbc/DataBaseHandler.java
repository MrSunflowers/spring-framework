package org.springframework.myTest.jdbc;

import org.springframework.core.io.Resource;

import javax.sql.DataSource;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.*;
import java.util.Properties;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/2/24
 */
public class DataBaseHandler {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, MalformedURLException, InstantiationException, IllegalAccessException {
		String fileUrlString = new File("D:\\Data\\GitHub Repository\\spring-framework\\spring-test\\src\\main\\java\\lib\\mysql-connector-java-8.0.25.jar").toURI().toString();
		fileUrlString = fileUrlString.replaceAll("!/", "%21/");
		ClassLoader classLoader = new URLClassLoader(new URL[]{new URL(fileUrlString)});
		Class<?> aClass = classLoader.loadClass("com.mysql.cj.jdbc.Driver");

		Driver driver = (Driver) aClass.newInstance();
		DriverManager.registerDriver(driver);
		Properties p = new Properties();
		p.put("user", "root");
		p.put("password", "root");
		//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb",p);
		Connection connection = driver.connect("jdbc:mysql://localhost:3306/mydb",p);

		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from user");
		while (resultSet.next()){
			System.out.println(resultSet.getInt("age"));
			System.out.println(resultSet.getString("name"));
		}
		resultSet.close();
		statement.close();
		connection.close();
	}



}
