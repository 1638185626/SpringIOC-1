package com.leeue.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 
 * @classDesc: 功能描述:(使用fastjson 解析)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午1:46:10
 */
public class JSONDemo01 {
	// 转义 把" 变成 \"
	public static String jsonStr = "{\"id\": \"001\",\"name\": \"里约\",\"items\": [{\"itemId\": \"002\",\"itemName\": \"嘻嘻\"}, {\"itemId\": \"002\",\"itemName\": \"嘻嘻\"}]}";

	public static void main(String[] args) {
		// new JSONObject();
		// 1、先将json字符串转换成jsonObject对象来操作。
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);

		String id = jsonObject.getString("id");
		System.out.println("id:" + id);
		String name = jsonObject.getString("name");
		System.out.println("name:" + name);
		// 取jsonArray类型
		JSONArray jsonArray = jsonObject.getJSONArray("items");

		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject object = jsonArray.getJSONObject(i);
			String itemId = object.getString("itemId");
			System.out.println("itemId:" + itemId);
			String itemName = object.getString("itemName");
			System.out.println("itemName:" + itemName);
		}

	}
}
