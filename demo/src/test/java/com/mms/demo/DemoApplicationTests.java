package com.mms.demo;

import com.mms.demo.mapper.CartMapper;
import com.mms.demo.mapper.LogMapper;
import com.mms.demo.mapper.ProductMapper;
import com.mms.demo.mapper.UserMapper;
import com.mms.demo.model.LogInfo;
import com.mms.demo.model.Product;
import com.mms.demo.model.User;
import com.mms.demo.service.MailService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private LogMapper logMapper;

	@Resource
	private MailService mailService;

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
	@Test
	void findAllProduct(){
		Product p = productMapper.findProductById(1);
		List<Product> products = cartMapper.findUserCart(1);
		for (Product product:products) {
			System.out.println(product.getName());
		}
	}

	@Test
	void findUserCart(){
		List<Product> products = productMapper.findAllProduct();
		for (Product product:products) {
			System.out.println(product.getName());
		}
	}

	@Test
	void sendMail(){
		mailService.sendSimpleMail("csjlang@mail.scut.edu.cn",
				"870245707@qq.com",
				"test",
				"hello world!");
	}

	@Test
	void LogTest(){
		logMapper.addLog(1,1, "2023-12-10 11:16:29", 1);
		logMapper.addLog(1,2, "2023-12-10 12:36:20", 2);
		List<LogInfo> logInfos =  logMapper.findAllLog();
	}
}
