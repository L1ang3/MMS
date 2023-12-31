package com.mms.demo.controller;

import com.mms.demo.comm.Result;
import com.mms.demo.mapper.CartMapper;
import com.mms.demo.mapper.ProductMapper;
import com.mms.demo.model.Product;
import com.mms.demo.model.User;
import com.mms.demo.service.ShopService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class ShopController {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CartMapper cartMapper;

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        List<Product> products = productMapper.findAllProduct();
        model.addAttribute("products", products);
        return "html/welcome";

    }

    @RequestMapping("/viewcart")
    public String viewCart(Model model,HttpSession session) {
        Object atr = session.getAttribute("id");
        int id = (Integer)atr;
        List<Product> products = cartMapper.findUserCart(id);
        model.addAttribute("products", products);
        return "html/viewcart";

    }

    @PostMapping("/addcart")
    @ResponseBody
    public Result addToCart(@RequestParam("productId") int productId,@RequestParam("quantity") int quantity, HttpSession session) {
        Object atr = session.getAttribute("id");
        if(atr == null){
            return Result.err("not login");
        }
        int id = (Integer)atr;
        if(cartMapper.isOrderExisted(id,productId)>0){
            cartMapper.addOrder(id,productId,quantity);
        }
        else{
            cartMapper.insertOrder(id,productId,quantity);
        }
        return Result.ok(null);
    }

    @GetMapping("/productDetails")
    public String getProductDetails(int productId,Model model) {
        // Logic to retrieve product details based on productId
        Product product = productMapper.findProductById(productId);

        // Pass the product details to the details page
        model.addAttribute("product", product);
        return "html/detail";
    }


    @PostMapping("/removecart")
    @ResponseBody
    public Result removeToCart(@RequestParam("productId") int productId, HttpSession session) {
        Object atr = session.getAttribute("id");
        if(atr == null){
            return Result.err("not login");
        }
        int id = (Integer)atr;
        cartMapper.removeOrder(id,productId);
        return Result.ok(null);
    }


    @PostMapping("/checkout")
    @ResponseBody
    public Result checkout(@RequestBody List<String> selectedProducts, HttpSession session) {
        Object atr = session.getAttribute("id");
        if(atr == null){
            return Result.err("not login");
        }
        int id = (Integer)atr;
        for(String productId:selectedProducts){
            cartMapper.removeOrder(id,Integer.parseInt(productId));
        }
        return Result.ok(null);
    }
}
