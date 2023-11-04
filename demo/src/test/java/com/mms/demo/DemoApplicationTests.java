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

}
