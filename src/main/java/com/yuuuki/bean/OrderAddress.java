package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order_address")
public class OrderAddress {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer order_id;
    private String address;
    private String tel;
    private String name;
}
