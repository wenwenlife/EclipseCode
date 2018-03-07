package ProxyTest;

/**
 * 
 * @Description: 目标类
 */
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
