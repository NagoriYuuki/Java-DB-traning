package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Product;
import com.yuuuki.mapper.ProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceImpl<ProductMapper, Product> {
}

