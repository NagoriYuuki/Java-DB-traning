package com.yuuuki.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    //  下面两个为外键 需要哈希值转化为字符串
    private Integer category_id;
    private Integer brand_id;
    private String image;
    private BigDecimal price;
    private Integer status;
    @TableLogic
    //    默认会把_转化为驼峰命名法 需要修改
    private Integer del_flag;
    //    是否软删除
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime creat_time;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime update_time;
    @TableField(exist = false)
    private Category category;
    @TableField(exist = false)
    private Brand brand;
}
