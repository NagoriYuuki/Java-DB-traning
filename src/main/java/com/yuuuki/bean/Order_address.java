package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Order_address {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer order_id;
    private String address;
    private String tel;
    private String name;
}
