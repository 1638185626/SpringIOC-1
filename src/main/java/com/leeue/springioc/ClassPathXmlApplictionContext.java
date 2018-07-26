package com.leeue.springioc;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 
 * @classDesc: 功能描述:(使用dom4j+java反射机制实现 springIOC 功能)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月26日 上午9:41:07
 */
public class ClassPathXmlApplictionContext {
	// 传入进来的applicationContext.xml路径
	private static String PATH;
	
	private static String ID;
	private static String CLASS;
	
	private static String NAME;
	private static String VALUE;
	public void init() {
		ID = "id";
		CLASS = "class";
		NAME="name";
		VALUE = "value";
	}

	public ClassPathXmlApplictionContext(String path) {
		this.PATH = path;
		//初始化一些基本字符
		init();
	}

	public Object getBean(String beanId) throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException {
		// 如果beanId传入的为空，直接返回空
		if (StringUtils.isEmpty(beanId)) {
			return null;
		}

		// 1、解析xml文件
		SAXReader saxReader = new SAXReader();
		// 2、读取路径加载文件
		Document document = 
				saxReader.read(this.getClass().getClassLoader().getResource(PATH));
		
		//3、获取根节点  beans
		Element rootElement = document.getRootElement();
		//4、获取根节点里面的所有子节点  配置的bean
		List<Element> elements = rootElement.elements();
		//5、遍历所有子节点
		for(Element element: elements) {
			//6、获取id属性 值
			String id = element.attributeValue(ID);
			//7、判断这个id属性值是否是自己要找的，如果不是则继续遍历下一个
			if(!beanId.equals(id)) {
				continue;
			}
			//8、找到了这个id属性值相等了，获取class属性值
			String className = element.attributeValue(CLASS);
			//9、使用反射机制 创建这个对象
			Class<?> forName = Class.forName(className);
			//10、使用forName这个来创建这个对象
			Object newInstance = forName.newInstance();
			//11、获取这个bean下的 property这些配置
			List<Element> childElements = element.elements();
			for(Element childElement:childElements) {
				//12 、获取name的属性值
				String name = childElement.attributeValue(NAME);
				//13、获取value属性值
				String value = childElement.attributeValue(VALUE);
				//14、通过反射机制获取这个这个私有属性
				Field field = forName.getDeclaredField(name);
				field.setAccessible(true);
				field.set(newInstance, value);
				
			}
			return newInstance;
		}
		return null;
	}

}