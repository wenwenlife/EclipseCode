package ProxyTest;

import org.junit.jupiter.api.Test;

class ProxyT {

	@Test
	void test() {
		Service service = ProxyImpl.createService();
		service.addUser();
	}

}
