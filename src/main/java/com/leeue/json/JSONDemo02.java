package com.leeue.json;

import com.alibaba.fastjson.JSONObject;
import com.leeue.entity.User;

/**
 * 
 * @classDesc: 功能描述:(将json数据文件 转换程对象)
 * @author:<a href="leeue@foxmail.com">李月</a>
 * @Version:v1.0
 * @createTime:2018年7月25日 下午1:56:59
 */
public class JSONDemo02 {
	public static String jsonStr = "{\"id\": \"001\",\"name\": \"里约\",\"items\": [{\"itemId\": \"002\",\"itemName\": \"嘻嘻\"}, {\"itemId\": \"002\",\"itemName\": \"嘻嘻\"}]}";

	public static void main(String[] args) {
		User user = (User) new JSONObject().parseObject(jsonStr,User.class);
		
		System.out.println(user.toString());
	}
}
