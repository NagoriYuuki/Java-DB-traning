package com.yuuuki.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yuuuki.bean.Admin;
import com.yuuuki.mapper.AdminMapper;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceImpl<AdminMapper, Admin> {
}

