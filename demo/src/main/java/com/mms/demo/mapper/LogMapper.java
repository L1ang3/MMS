package com.mms.demo.mapper;

import com.mms.demo.model.LogInfo;
import com.mysql.cj.log.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface LogMapper {
    public void addLog(@Param("userid") int userid, @Param("productid") int productid,
                       @Param("updatetime") String updatetime, @Param("actionid") int actionid);
    public List<LogInfo> findAllLog();
}
