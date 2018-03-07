package cn.strong.FactoryExample;

import cn.strong.Factory.Computer;

public class TestXMLApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new XmlApplicationContext("F:/ItSoftware/source/Pattern/src/bean.xml");
		Computer c = (Computer) ac.getBean("computer");
		c.keyIn("成功");
	}
}
