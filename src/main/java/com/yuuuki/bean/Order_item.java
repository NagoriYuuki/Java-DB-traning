package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order_item {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer product_id;
    private BigDecimal price;
    private Integer count;
    private Integer order_id;
}
