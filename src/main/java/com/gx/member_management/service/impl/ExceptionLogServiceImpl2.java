package com.gx.member_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gx.member_management.persistence.entity.ExceptionLog2;
import com.gx.member_management.persistence.db2.mapper.ExceptionLogMapper2;
import com.gx.member_management.service.ExceptionLogService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExceptionLogServiceImpl2 extends ServiceImpl<ExceptionLogMapper2, ExceptionLog2> implements ExceptionLogService2 {


    @Autowired
    private ExceptionLogMapper2 exceptionLogMapper2;


    public List<ExceptionLog2> getDataByInstId(String id){
        return exceptionLogMapper2.getDataByInstId(id);
    };
    public List<ExceptionLog2> getAllData(){
        return exceptionLogMapper2.getAllData();
    };
}
