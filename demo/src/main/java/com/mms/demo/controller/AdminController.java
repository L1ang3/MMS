package com.mms.demo.controller;

import com.mms.demo.comm.Result;
import com.mms.demo.mapper.LogMapper;
import com.mms.demo.mapper.ProductMapper;
import com.mms.demo.model.LogInfo;
import com.mms.demo.model.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private LogMapper logMapper;
    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/addlog")
    @ResponseBody
    public Result addlog(@RequestParam("productId") int productId,
                         @RequestParam("messageId") int messageId,
                         @RequestParam("date") String date,
                         HttpSession session){
        Object atr = session.getAttribute("id");
        if(atr == null){
            return Result.err("not login");
        }
        int id = (Integer)atr;
        logMapper.addLog(id,productId,date,messageId);
        return Result.ok(null);
    }

    @GetMapping("/admin/viewlog")
    public String viewlog(Model model){
        List<LogInfo> logInfoList = logMapper.findAllLog();
        model.addAttribute("activityRecords",logInfoList);
        return "html/admin";
    }

    @GetMapping("/admin/products")
    public String showAllProducts(Model model) {
        List<Product> products = productMapper.findAllProduct();
        model.addAttribute("products", products);
        return "html/admin-products";
    }
}
