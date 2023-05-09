package com.gx.member_management.persistence.db2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gx.member_management.persistence.entity.ExceptionLog2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface ExceptionLogMapper2 extends BaseMapper<ExceptionLog2> {
    List<ExceptionLog2> getDataByInstId(@Param("id") String id);
    List<ExceptionLog2> getAllData();

}
