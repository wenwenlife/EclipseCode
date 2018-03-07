package cn.strong.wen;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 
 * 
 * @Description: Dbcp连接池操作数据库
 */
public class SpringJdbcTemplat {

	public static void main(String[] args) {
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql://localhost:3306/a?useUnicode=true&characterEncoding=utf8");
		datasource.setUsername("root");
		datasource.setPassword("123");

		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(datasource);
		jt.update("INSERT INTO person(NAME,PASSWORD) VALUES(?,?);", "哦哦", 123456);
	}
}
