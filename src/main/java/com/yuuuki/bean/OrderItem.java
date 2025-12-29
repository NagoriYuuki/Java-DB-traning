package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName(value = "order_item")
public class OrderItem {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer product_id;
    private BigDecimal price;
    private Integer count;
    private Integer order_id;
    @TableField(exist = false)
    private Product product;
}
