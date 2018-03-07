package SpringAOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void Springtest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean9.xml");
		Service service = (Service) ac.getBean("ServletImpl");
		service.addUser();
		service.deleteUser();
	}
}
