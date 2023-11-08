package com.mms.demo.controller;

import com.mms.demo.mapper.ProductMapper;
import com.mms.demo.model.Product;
import com.mms.demo.service.ShopService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShopController {
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping("/welcome")
    public String welcome(HttpServletRequest request) {
        List<Product> products = productMapper.findAllProduct();
        request.setAttribute("products",products);
        return "html/welcome.html";
    }

}
