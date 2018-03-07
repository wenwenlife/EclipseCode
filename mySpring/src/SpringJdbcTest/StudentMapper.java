package SpringJdbcTest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//直接jdbcTemplate.query(sql,new UserRowMapper)即可将查询的信息存入java Bean中，靠的是bean中的get/set方法。
public class StudentMapper implements RowMapper<StudentBean> {
	public StudentBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		StudentBean student = new StudentBean();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setAge(rs.getInt("age"));
		return student;
	}
}