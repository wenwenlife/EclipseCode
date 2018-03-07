package SpringAspect;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	@Test
	public void Springtest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean10.xml");
		Service service = (Service) ac.getBean("ServletImplId");
		service.addUser();
		service.deleteUser();
	}
}
