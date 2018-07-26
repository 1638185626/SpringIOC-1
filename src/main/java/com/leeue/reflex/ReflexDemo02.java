package com.leeue.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.leeue.entity.User;

/**
 * 
 * @classDesc: 功能描述:(使用反射机制修改私有属性 )
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午3:38:14
 */
public class ReflexDemo02 {
	public static void main(String[] args) throws Exception {
		//1.使用java的反射机制获取类的所有属性方法，并且唯私有属性赋值。
		Class<?> forName = Class.forName("com.leeue.entity.User");
		//2.获取到当前类的所有属性
		Field[] declaredFields = forName.getDeclaredFields();
		for(Field fieled:declaredFields) {
			//打印出属性名称
			System.out.println(fieled.getName());
		}
		//3获取当前类的所有方法
		Method[] declaredMethods =  forName.getDeclaredMethods();
		
		for(Method method:declaredMethods) {
			System.out.println(method.getName());
		}
		
		//4、使用java的反射机制修改私有属性赋值
		Object newInstance = forName.newInstance();
		//获取id这个私有属性
		Field fileId = forName.getDeclaredField("id");
		//要设置这个 允许反射操作私有属性，如果不加会报错
		fileId.setAccessible(true);
		//给id赋值
		fileId.set(newInstance, "20");
	
	
		Field fileName = forName.getDeclaredField("name");
		fileName.setAccessible(true);
		fileName.set(newInstance, "哈哈哈");
	
		//强转成user对象
		User user = (User) newInstance;
		
		System.out.println(user.toString());
		
		
	}
}
