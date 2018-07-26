package com.leeue.entity;

import java.util.List;

/**
 * 
 * @classDesc: 功能描述:(User 对象  对应案例fastjson来解析对象)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午1:53:28
 */
public class User {
	private String name;
	private String id;
	private List<Item> items;
	public User() {
		System.out.println("我User对象被创建了");
	}
	public User(String id,String name) {
		this.id = id;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", items=" + items + "]";
	}
	
	
	
	
	
}
