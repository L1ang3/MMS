package com.mms.demo.model;

public class User {
    private int id;
    private String name;
    private String passwd;
    private String email;
    private String addr;
    private String phone;
    private boolean isadmin;

    public  User(){}

    public User(String name,String passwd,String email,String addr,String phone,boolean isadmin){
        this.name = name;
        this.passwd = passwd;
        this.email = email;
        this.addr = addr;
        this.phone = phone;
        this.isadmin = isadmin;
    }

    public int getId(){return id;}
    public String getPasswd(){return passwd;}

    public String getName(){return name;}
}
