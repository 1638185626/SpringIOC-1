package com.leeue.xml;



import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XMLDemo01 {
	public static void main(String[] args) throws DocumentException {
		//1、获取到读取对象
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("student.xml");
		//获取根节点 获取到根节点就能获取到所有的节点了
		Element rootElement = document.getRootElement();
		getNodes(rootElement);
	}
	
	public static void getNodes(Element rootElement) {
		String name = rootElement.getName();
		System.out.println("节点名称："+name);
		//获取节点属性
		List<Attribute> attributes = rootElement.attributes();
		for (Attribute attribute:attributes) {
			System.out.println("属性名称"+attribute.getName()+"---"+attribute.getText());
		}
		//获取值
		String value = rootElement.getTextTrim();
		if(!value.equals("")) {
			System.out.println("节点属性名称:"+value);
		}
		
		//判断是否还有下个节点
		Iterator<Element> elementIterator = rootElement.elementIterator();
		while (elementIterator.hasNext()) {
			Element next = elementIterator.next();//拿到下个节点
			getNodes(next);
		}
		
	}
}
