package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mapper.UserMapper;


public class FindUserByIdTest {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/Spring/application-context.xml");
		UserMapper userMapper = (UserMapper) ac.getBean("userMapperImpl");
		System.out.println(userMapper.fingUserById(1));

}
}
