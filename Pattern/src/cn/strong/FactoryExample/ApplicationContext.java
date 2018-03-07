package cn.strong.FactoryExample;

public interface ApplicationContext {
	// 获取指定bean实例的方法
	Object getBean(String name) throws Exception;
}
