package SpringJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJdbcTest {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		StudentDao sd = ac.getBean("jdbcTemple", StudentDaoImpl.class);
		sd.create("文", 12);
	}
}
