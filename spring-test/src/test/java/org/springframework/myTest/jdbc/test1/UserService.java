package org.springframework.myTest.jdbc.test1;

import java.util.List;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/2/24
 */
public interface UserService {
	void save(User user);
	List<User> getUsers();
}
