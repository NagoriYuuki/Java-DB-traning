package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String image;
    private String name;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime creat_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime update_time;
}
