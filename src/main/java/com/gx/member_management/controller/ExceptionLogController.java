package com.gx.member_management.controller;


import com.gx.member_management.param.response.AjaxResult;
import com.gx.member_management.param.response.HttpStatus;
import com.gx.member_management.service.ExceptionLogService;

import com.gx.member_management.service.ExceptionLogService2;
import com.gx.member_management.utils.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/exceptionLog")
public class ExceptionLogController {

    @Autowired
    private ExceptionLogService exceptionLogService;

    @Autowired
    private ExceptionLogService2 exceptionLogService2;
    @RequestMapping("/getDataByInstId")
    public AjaxResult getDataByInstId(String  id) {

        return new AjaxResult(HttpStatus.SUCCESS,"111",exceptionLogService.getDataByInstId(id));
    }
    @RequestMapping("/getAllData")
    public AjaxResult getAllData() {
        LogUtils.getErLogger().info("getErLogger");
        LogUtils.getBizLogger().info("getBizLogger");
        LogUtils.getDbLogger().info("getDbLogger");
        LogUtils.getPlLogger().info("getPlLogger");
        return new AjaxResult(HttpStatus.SUCCESS,"111",exceptionLogService.getAllData());
    }

    @RequestMapping("/getAllData2")
    public AjaxResult getAllData2() {
        return new AjaxResult(HttpStatus.SUCCESS,"111",exceptionLogService2.getAllData());
    }



}
