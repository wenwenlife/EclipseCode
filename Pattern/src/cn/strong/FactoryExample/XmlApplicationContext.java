package cn.strong.FactoryExample;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


/**
 * 
 * 
 * @Description: 根据配置文件创建工厂中的bean
 */
public class XmlApplicationContext implements ApplicationContext {

	// 保存容器中所有的单例模式的Bean实例
	private Map<String, Object> objPool = Collections.synchronizedMap(new HashMap<String, Object>());
	// 保存配置文件中对应的Document对象
	private Document doc;
	// 保存配置文件里的根元素
	private Element root;

	public XmlApplicationContext(String filePath) throws Exception {
		// 创建读取XML文件的对象
		SAXReader reader = new SAXReader();
		// 获取配置文件中对应的Document对象
		doc = reader.read(new File(filePath));
		// 获取配置文件里的根元素
		root = doc.getRootElement();

		initPool();
		intProp();
	}

	public Object getBean(String name) throws Exception {
		Object target = objPool.get(name);
		if (target.getClass() != String.class) {
			return target;
		} else {
			String clazz = (String) target;
			// 创建对象
			return Class.forName(clazz).newInstance();
		}
	}

	// 初始化容器中所有的singleton Bean
	private void initPool() throws Exception {
		for (Object obj : root.elements()) {
			Element beanEle = (Element) obj;
			// 取得bean的id属性
			String beanId = beanEle.attributeValue("id");
			// 取得bean的class属性
			String beanClazz = beanEle.attributeValue("class");
			String beanScope = beanEle.attributeValue("scope");
			if (beanScope == null || beanScope.equals("singleton")) {
				objPool.put(beanId, Class.forName(beanClazz).newInstance());
			} else {
				// 对于非singleton Bean,存放该Bean实现类的类名
				objPool.put(beanId, beanClazz);
			}
		}
	}

	// 初始化容器中Singleton属性
	private void intProp() throws Exception {
            //遍历配置文件里的每个<bean>元素
		for (Object obj : root.elements()) {
			Element beanEle = (Element) obj;
			// 获得bean的id属性
			String beanId = beanEle.attributeValue("id");
			// 获取scope属性
			String beanScope = beanEle.attributeValue("scope");
			if(beanScope==null||beanScope.equals("singleton")) {
				//取出objPool的指定的Bean实例
				Object bean =objPool.get(beanId);
				for (Object prop : beanEle.elements()) {
					Element propEle = (Element) prop;
					// 取得<bean>的name值
					String propName = propEle.attributeValue("name");
					// 取得bean的value值
					String propValue = propEle.attributeValue("value");

					// 取得bean的ref值
					String propRef = propEle.attributeValue("ref");
					// 将属性名首字母大写
					String propNameCamelize = propName.substring(0, 1).toUpperCase() + propName.substring(1);
					if (propValue != null && propValue.length() > 0) {
						Method setter = bean.getClass().getMethod("set" + propNameCamelize, String.class);
						setter.invoke(bean, propValue);
					}
					if (propRef != null && propRef.length() > 0) {
						// 取得希望被依赖注入的bean实例
						Object target = objPool.get(propRef);
						if (target == null) {
							// 还应该处理Singleton Bean依赖property Bean
						}
						// 定义设值注入的setter方法
						Method setter = null;
						// 遍历target对象所实现的所有接口
						for (Class superInterface : target.getClass().getInterfaces()) {
							try {
								// 获取设值注入所需的setter方法
								setter = bean.getClass().getMethod("set" + propNameCamelize, superInterface);
								// 如果成功获取接口对应方法,直接跳出循环
							} catch (Exception e) {
								continue;
							}
						}

						// 如果setter方法依然为null ,则直接取得target实现类对应的setter方法
						if (setter == null) {
							setter = bean.getClass().getMethod("set" + propNameCamelize, target.getClass());
						}
						setter.invoke(bean, target);
					}
				}
			}
		}
	}



}
