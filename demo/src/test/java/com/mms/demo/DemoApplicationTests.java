package com.mms.demo;

import com.mms.demo.mapper.CartMapper;
import com.mms.demo.mapper.ProductMapper;
import com.mms.demo.mapper.UserMapper;
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

}
