package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Brand;
import com.yuuuki.mapper.BrandMapper;
import org.springframework.stereotype.Service;

@Service
public class BrandService extends ServiceImpl<BrandMapper, Brand> {
}

