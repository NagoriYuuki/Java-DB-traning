package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Brand {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String image;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime update_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime create_time;
}
