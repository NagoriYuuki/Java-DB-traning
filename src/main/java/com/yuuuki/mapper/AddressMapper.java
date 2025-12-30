package com.yuuuki.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.yuuuki.bean.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;


@Mapper
public interface AddressMapper extends BaseMapper<Address> {
}
