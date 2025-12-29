package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer category_id;
    private Integer brand_id;
    private String image;
    private BigDecimal price;
    private Integer status;
    private Integer del_flag;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime creat_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime update_time;
}
