package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Category;
import com.yuuuki.service.CategoryService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Result add(@RequestBody Category category) {
        categoryService.save(category);
        category = categoryService.getById(category.getId());
        return Result.success("分类新增成功", category);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Category category) {
        categoryService.updateById(category);
        category = categoryService.getById(category.getId());
        return Result.success("分类编辑成功", category);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        categoryService.removeById(id);
        return Result.success("分类删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Category category = categoryService.getById(id);
        return Result.success("", category);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Category::getName, searchtext);
        // 可扩展：添加其他字段的模糊查询
        // queryWrapper.like(Category::getImage, searchtext);
        
        page = categoryService.page(page, queryWrapper);
        return Result.success("", page);
    }
}