package SpringAspectAnnotion;

import org.springframework.stereotype.Component;

/**
 * 
 * @Description: 目标类
 */

@Component("serviceimpl")
public class ServiceImpl implements Service {

	@Override
	public void addUser() {
		System.out.println("addUser");
	}

	@Override
	public void deleteUser() {
		System.out.println("deleteUser");
	}

}
