package com.mms.demo.comm;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Result {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private int code;
    private String msg;
    private Object data;

    public int getCode(){return code;}

    public String getMsg(){return msg;}

    public Object getData(){return data;}
    public Result(int code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public static Result ok(Object data){
        return new Result(200,"OK",data);
    }

    public static Result err(String msg){
        return new Result(500,msg,null);
    }

}
