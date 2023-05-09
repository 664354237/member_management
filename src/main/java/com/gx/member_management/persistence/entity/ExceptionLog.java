package com.gx.member_management.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gx.member_management.param.response.AjaxResult;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName("exception_log")
public class ExceptionLog {

    @TableId
    private String id;

    private String content;

    private Date time;




//    @TableField(exist = false)
//    private List<ApprovalItemEntity> childList = new ArrayList<>();
//
//    public ApprovalItemEntity() {
//        // do nothing
//    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
    /**
     * 初始化ExceptionLog 对象
     */
    public ExceptionLog() {}

    public  ExceptionLog (String id,Date time, String content)
    {
        this.id=id;
        this.content=content;
        this.time=time;
    }
}
