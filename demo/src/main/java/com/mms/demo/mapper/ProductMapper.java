package com.mms.demo.mapper;

import com.mms.demo.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
    public List<Product> findAllProduct();
    public  Product findProductById(@Param("id")int id);
}
