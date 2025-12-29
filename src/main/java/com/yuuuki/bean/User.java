package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@Data
//自动生成 getter setter equals hashcode toString
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private Integer status;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime last_login_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime registration_data;
}
