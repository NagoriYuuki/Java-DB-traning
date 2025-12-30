package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Cart;
import com.yuuuki.service.CartService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public Result add(@RequestBody Cart cart) {
        cartService.save(cart);
        cart = cartService.getById(cart.getId());
        return Result.success("购物车项新增成功", cart);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Cart cart) {
        cartService.updateById(cart);
        cart = cartService.getById(cart.getId());
        return Result.success("购物车项编辑成功", cart);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        cartService.removeById(id);
        return Result.success("购物车项删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Cart cart = cartService.getById(id);
        return Result.success("", cart);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Cart> queryWrapper = new LambdaQueryWrapper<>();
        // Cart表无字符串字段，无法进行模糊查询（实际业务中可能需关联商品表）
        // 保持与样例结构一致，不添加任何条件
        page = cartService.page(page, queryWrapper);
        return Result.success("", page);
    }
}