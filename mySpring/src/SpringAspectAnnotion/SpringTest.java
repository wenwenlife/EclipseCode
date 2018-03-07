package SpringAspectAnnotion;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void Springtest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean11.xml");
		Service service = (Service) ac.getBean("serviceimpl");
		service.addUser();
		service.deleteUser();
	}
}
