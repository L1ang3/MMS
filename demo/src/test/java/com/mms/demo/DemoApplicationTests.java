package com.mms.demo;

import com.mms.demo.mapper.UserMapper;
import com.mms.demo.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
	}

	@Test
	void findUser(){
		User user= userMapper.findUserByName("admin");
		System.out.println(user);
	}

	@Test
	void insertUser(){
		User user= new User("test","123","@.com","0","0",false);
		if(userMapper.isNameExisted("test")==0){
			userMapper.insertUser(user);
		}
	}
}
