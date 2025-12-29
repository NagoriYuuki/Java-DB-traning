package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Address {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    @TableField(value = "default")
    private Integer defaultStatus;
    private String province_name;
    private String province_code;
    private String city_name;
    private String city_code;
    private String area_name;
    private String area_code;
    private String detail_address;
    private String recipient;
    private String tel;
}
