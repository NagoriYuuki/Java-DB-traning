package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Collection {
    @TableId(type = IdType.AUTO)
    private Integer product_id;
    private Integer user_id;
    @TableField(exist = false)
    private Product product;
}
