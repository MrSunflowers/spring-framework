package org.springframework.myTest.jdbc.test1;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description
 * @Author lyk
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2022/2/24
 */
public class UserRowMapper implements RowMapper<User> {
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(rs.getInt("id"),rs.getString("name"),rs.getInt("age"));
	}
}
