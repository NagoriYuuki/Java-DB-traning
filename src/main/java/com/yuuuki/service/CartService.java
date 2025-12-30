package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Cart;
import com.yuuuki.mapper.CartMapper;
import org.springframework.stereotype.Service;

@Service
public class CartService extends ServiceImpl<CartMapper, Cart> {
}

