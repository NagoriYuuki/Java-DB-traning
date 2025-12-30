package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Order;
import com.yuuuki.service.OrderService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Result add(@RequestBody Order order) {
        orderService.save(order);
        order = orderService.getById(order.getId());
        return Result.success("订单新增成功", order);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Order order) {
        orderService.updateById(order);
        order = orderService.getById(order.getId());
        return Result.success("订单编辑成功", order);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        orderService.removeById(id);
        return Result.success("订单删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        return Result.success("", order);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Order::getCode, searchtext);
        // 可扩展：添加其他字段的模糊查询
        // queryWrapper.like(Order::getAmount, searchtext);
        
        page = orderService.page(page, queryWrapper);
        return Result.success("", page);
    }
}