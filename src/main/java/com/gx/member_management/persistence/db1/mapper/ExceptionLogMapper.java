package com.gx.member_management.persistence.db1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gx.member_management.persistence.entity.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ExceptionLogMapper extends BaseMapper<ExceptionLog> {
    List<ExceptionLog> getDataByInstId(@Param("id") String id);
    List<ExceptionLog> getAllData();

}
