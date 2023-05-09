package com.gx.member_management.exception.exception_handler;


import com.gx.member_management.param.response.AjaxResult;
import com.gx.member_management.param.response.HttpStatus;
import com.gx.member_management.persistence.entity.ExceptionLog;
import com.gx.member_management.persistence.db1.mapper.ExceptionLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@ControllerAdvice
public class CustomExceptionHandler {

    Logger expLogger = LoggerFactory.getLogger("exception");
    @Autowired
    private ExceptionLogMapper exceptionLogMapper;

    /**
     * 顶级异常捕获
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object runtimeExceptionHandler(RuntimeException e) {
        //输出记录打到本地日志
        expLogger.info("RuntimeException", e);
        //记录到数据库
        exceptionLogMapper.insert(new ExceptionLog(UUID.randomUUID().toString(), new Date(), e.toString()));
        return new AjaxResult(HttpStatus.ERROR, "网络出小差了, 请稍后再试,或者联系管理员");

    }
//    @ExceptionHandler(TokenException.class)
//    @ResponseBody
//    public AjaxResult<Object> handle(TokenException pushException){
//        expLogger.error("pushException",pushException);
//        AjaxResult<Object> result = new AjaxResult<>();
//        result.setError(StatusCode.REQUEST_CODE_ERROR,pushException.getMessage());
//        return result;
//    }
//    @ExceptionHandler(SQLException.class)
//    @ResponseBody
//    public AjaxResult<Object> handle(SQLException sqlException){
//        expLogger.error("sqlException",sqlException);
//        AjaxResult<Object> result = new AjaxResult<>();
//        result.setError(StatusCode.REQUEST_CODE_ERROR,"数据库数据异常, 请稍后再试,或者联系管理员");
//        return result;
//    }


}
