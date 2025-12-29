package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Admin {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String adminname;
    private String password;
    private String realname;
    private Integer status;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime last_login_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime registration_data;
}
