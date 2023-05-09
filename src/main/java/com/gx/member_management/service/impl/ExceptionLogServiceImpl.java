package com.gx.member_management.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gx.member_management.persistence.entity.ExceptionLog;
import com.gx.member_management.persistence.db1.mapper.ExceptionLogMapper;

import com.gx.member_management.service.ExceptionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExceptionLogServiceImpl extends ServiceImpl<ExceptionLogMapper, ExceptionLog> implements ExceptionLogService {


    @Autowired
    private ExceptionLogMapper exceptionLogMapper;


    public List<ExceptionLog> getDataByInstId(String id){
        return exceptionLogMapper.getDataByInstId(id);
    };
    public List<ExceptionLog> getAllData(){
        return exceptionLogMapper.getAllData();
    };
}
