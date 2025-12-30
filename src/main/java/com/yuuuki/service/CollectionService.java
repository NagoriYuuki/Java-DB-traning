package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Collection;
import com.yuuuki.mapper.CollectionMapper;
import org.springframework.stereotype.Service;

@Service
public class CollectionService extends ServiceImpl<CollectionMapper, Collection> {
}

