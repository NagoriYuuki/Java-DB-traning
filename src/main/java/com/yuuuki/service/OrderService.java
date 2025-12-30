package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Order;
import com.yuuuki.mapper.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService extends ServiceImpl<OrderMapper, Order> {
}

