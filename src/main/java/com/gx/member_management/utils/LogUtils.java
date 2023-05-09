package com.gx.member_management.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
  * @创建人 huanghesong
  * @创建时间  2023/5/9 11:06
  * @描述
 */
public class LogUtils {

    /**
     * 平台日志记录器
     *
     * @return {@link Logger}
     */
    public  static Logger getPlLogger(){
        return LoggerFactory.getLogger("platform");
    }
    /**
     * 数据库日志记录器
     *
     * @return {@link Logger}
     */
    public  static Logger getDbLogger(){
        return LoggerFactory.getLogger("db");
    }
    /**
     * 业务日志记录器
     *
     * @return {@link Logger}
     */
    public  static Logger getBizLogger(){
        return LoggerFactory.getLogger("bussiness");
    }
    /**
     * 异常日志记录器
     *
     * @return {@link Logger}
     */
    public  static Logger getErLogger(){
        return LoggerFactory.getLogger("exception");
    }
}
