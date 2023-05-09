package com.gx.member_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.member_management.persistence.entity.ExceptionLog2;

import java.util.List;

public interface ExceptionLogService2 extends IService<ExceptionLog2> {

    List<ExceptionLog2> getDataByInstId(String id);
    List<ExceptionLog2> getAllData();
}
