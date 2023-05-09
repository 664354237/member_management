package com.gx.member_management.persistence.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

@TableName("exception_log2")
public class ExceptionLog2 {

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
}
