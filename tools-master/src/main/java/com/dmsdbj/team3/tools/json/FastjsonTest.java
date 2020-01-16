package com.dmsdbj.team3.tools.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializeFilter;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname FastjsonTest
 * @Auther sunshinezhang
 * @Date 2019/10/5 08:39
 */
public class FastjsonTest {


	//对象转Json
	//String json = JSONObject.toJSONString(user,filter);
	//Json转对象
	//User parseObject = JSONObject.parseObject(json,User.class);


	// 将User对象转换成json
	@Test
	public void test1(){
		User user = new User();
		user.setAge(20);
		user.setBirthday(new Date());
		user.setId(1);
		user.setName("tom");


		SerializeFilter filter=new PropertyFilter() {
			@Override
			public boolean apply(Object o, String s, Object o1) {
				if (s.equals("id")) {
					return false;
				}
				return true;
			}
		};

		//转换成json
		String json = JSONObject.toJSONString(user, filter);
		System.out.println(json);
	}


	// 将List<User>转换成json
	@Test
	public void test2(){
		User user1 = new User();
		user1.setAge(20);
		user1.setBirthday(new Date());
		user1.setId(1);
		user1.setName("tom");

		User user2 = new User();
		user2.setAge(20);
		user2.setBirthday(new Date());
		user2.setId(1);
		user2.setName("fox");
		List<User> users = new ArrayList<>();
		users.add(user1);
		users.add(user2);

		String json = JSONArray.toJSONString(users);
		System.out.println(json);
	}




	@Data
	public class User{
		private int id;
		private String name;
		private int age;

		@JSONField(format="yyyy-MM-dd")
		private Date birthday;
	}
}
