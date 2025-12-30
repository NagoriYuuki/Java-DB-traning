package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Category;
import com.yuuuki.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {
}

