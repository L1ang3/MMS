package com.mms.demo.model;

public class Product {
    private Integer productId;
    private String name;
    private Double price;
    private String imgUrl;
    private Integer quantity;

    public Product(){}

    public Product(Integer productId,String name,Double price,String imgUrl,Integer quantity){
        this.productId=productId;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
        this.quantity = quantity;
    }

    public Integer getProductId(){return productId;}
    public String getName(){return name;}
    public String getImgUrl(){return imgUrl;}
    public Double getPrice(){return price;}
    public Integer getQuantity(){return quantity;}
}
