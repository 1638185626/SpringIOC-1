package com.leeue.json;
/**
 * 
 * @classDesc: 功能描述:(使用实体类封装成json字符串)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午2:15:31
 */

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.leeue.entity.Item;
import com.leeue.entity.User;

public class JSONDemo04 {
	
	public static void main(String[] args) {
		User user = new User();
		user.setId("23");
		user.setName("嘻嘻");
		List<Item> items = new ArrayList<Item>();
		Item item = new Item();
		item.setItemId("11");
		item.setItemName("哈哈");
		items.add(item);
		Item item2 = new Item();
		item2.setItemId("22");
		item2.setItemName("敷敷");
		items.add(item2);
		
		user.setItems(items);
		
		System.out.println(new JSONObject().toJSONString(user));
	}
}
