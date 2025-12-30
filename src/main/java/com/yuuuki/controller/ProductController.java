package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Product;
import com.yuuuki.service.ProductService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Result add(@RequestBody Product product) {
        productService.save(product);
        product = productService.getById(product.getId());
        return Result.success("商品新增成功", product);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Product product) {
        productService.updateById(product);
        product = productService.getById(product.getId());
        return Result.success("商品编辑成功", product);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        productService.removeById(id);
        return Result.success("商品删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Product product = productService.getById(id);
        return Result.success("", product);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Product::getName, searchtext);
        // 可扩展：添加其他字段的模糊查询
        // queryWrapper.like(Product::getImage, searchtext);
        
        page = productService.page(page, queryWrapper);
        return Result.success("", page);
    }
}