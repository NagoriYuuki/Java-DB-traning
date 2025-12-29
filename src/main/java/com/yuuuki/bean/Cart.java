package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Cart {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer product_id;
    private Integer count;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime update_time;
    private Integer check_status;
    @TableField(exist = false)
    private Product product;
}
