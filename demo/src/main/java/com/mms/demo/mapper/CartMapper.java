package com.mms.demo.mapper;

import com.mms.demo.model.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    public List<Product> findUserCart(@Param("userid")int userid);

    public void  insertOrder(@Param("userid") int userid,@Param("productid") int productid, @Param("quantity") int quantity);

    public int isOrderExisted(@Param("userid") int userid,@Param("productid") int productid);

    public void addOrder(@Param("userid") int userid,@Param("productid") int productid, @Param("quantity") int quantity);
    public void removeOrder(@Param("userid") int userid,@Param("productid") int productid);
}
