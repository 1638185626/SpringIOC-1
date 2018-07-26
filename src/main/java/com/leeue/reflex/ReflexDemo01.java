package com.leeue.reflex;

import java.lang.reflect.Constructor;

import com.leeue.entity.User;

/**
 * 
 * @classDesc: 功能描述:(使用java反射机制来创建对象)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午3:02:04
 */
public class ReflexDemo01 {
	public static void main(String[] args) throws Exception {
		// 1、new 方式创建对象
		// User user = new User();
		// 2、使用反射机制创建对象Class.forName("类的完整路径")
		Class forName = Class.forName("com.leeue.entity.User");

		// 使用默认无参构造函数创建对象
		User classUser = (User) forName.newInstance();

		System.out.println(classUser);

		// 使用有参数的构造函数创建对象。  String.class.表示传入的构造函数参数是什么类型的
		Constructor constructor = forName.getConstructor(String.class, String.class);
		User user = (User) constructor.newInstance("1", "xixi");

		System.out.println("使用有参数构造函数创建User:" + user.toString());

	}
}
