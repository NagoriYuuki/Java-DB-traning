package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String code;
    private Integer user_id;
    private BigDecimal amount;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime creat_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime payment_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime delivery_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime end_time;
}
