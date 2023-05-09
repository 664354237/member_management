package com.gx.member_management.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gx.member_management.persistence.entity.ExceptionLog;

import java.util.List;
import java.util.Map;

public interface ExceptionLogService extends IService<ExceptionLog> {

    List<ExceptionLog> getDataByInstId(String id);
    List<ExceptionLog> getAllData();
}
