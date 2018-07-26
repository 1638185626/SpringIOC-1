package com.leeue.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @classDesc: 功能描述:(自定义json字符串)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午2:08:10
 */
public class JSONDemo03 {
	public static void main(String[] args) {
		JSONObject root = new JSONObject();
		root.put("id", "23");
		root.put("name", "leeue");
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("itemId", "001");
		jsonObject.put("itemName", "打球");
		JSONObject jsonObject2 = new JSONObject();
		jsonObject2.put("itemId", "002");
		jsonObject2.put("itemName", "嘻嘻");
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject2);
		root.put("items", jsonArray);
		
		System.out.println(root.toJSONString());
	}
}
