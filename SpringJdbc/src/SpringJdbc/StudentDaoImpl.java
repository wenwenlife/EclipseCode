package SpringJdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;


public class StudentDaoImpl implements StudentDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public StudentDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void create(String name, int age) {
		String SQL = "insert into Student (name, age) values (?, ?)";
		jdbcTemplate.update(SQL, name, age);
		return;
	}

}
