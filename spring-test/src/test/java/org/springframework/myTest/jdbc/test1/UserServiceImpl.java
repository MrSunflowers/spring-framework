package org.springframework.myTest.jdbc.test1;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.List;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/2/24
 */
public class UserServiceImpl implements UserService{

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(User user) {
		jdbcTemplate.update("insert into user (name,age) values (?,?)",
				new Object[]{user.getName(),user.getAge()},
				new int[]{Types.VARCHAR,Types.INTEGER});
	}

	@Override
	public List<User> getUsers() {
		return jdbcTemplate.query("select * from user",new UserRowMapper());
	}
}
