package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Collection;
import com.yuuuki.service.CollectionService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @PostMapping("/")
    public Result add(@RequestBody Collection collection) {
        collectionService.save(collection);
        return Result.success("收藏成功", collection);
    }

    @DeleteMapping("/{product_id}/{user_id}")
    public Result delete(
            @PathVariable Integer product_id,
            @PathVariable Integer user_id) {
        LambdaQueryWrapper<Collection> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Collection::getProduct_id, product_id)
                .eq(Collection::getUser_id, user_id);
        collectionService.remove(queryWrapper);
        return Result.success("收藏删除成功");
    }

    @GetMapping("/{product_id}/{user_id}")
    public Result getById(
            @PathVariable Integer product_id,
            @PathVariable Integer user_id) {
        LambdaQueryWrapper<Collection> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Collection::getProduct_id, product_id)
                .eq(Collection::getUser_id, user_id);
        Collection collection = collectionService.getOne(queryWrapper);
        return Result.success("", collection);
    }

    @GetMapping("/")
    public Result getPage(
            Page page,
            @RequestParam("searchtext") String searchtext) {
        // 由于Collection无字符串字段，searchtext实际作为user_id使用
        Integer userId = Integer.parseInt(searchtext);
        LambdaQueryWrapper<Collection> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Collection::getUser_id, userId);
        page = collectionService.page(page, queryWrapper);
        return Result.success("", page);
    }
}