package com.leeue;

import org.dom4j.DocumentException;

import com.leeue.entity.User;
import com.leeue.springioc.ClassPathXmlApplictionContext;

/**
 * 
 * @classDesc: 功能描述:(测试手写SpringIOC是否正确)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月26日 上午10:10:39
 */
public class Test {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, SecurityException, DocumentException {
		ClassPathXmlApplictionContext classPathXmlApplictionContext = new ClassPathXmlApplictionContext("applicationContext.xml");
		User user = (User) classPathXmlApplictionContext.getBean("user1");
		System.out.println(user.toString());
	}
}
