package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Brand;
import com.yuuuki.service.BrandService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping("/")
    public Result add(@RequestBody Brand brand) {
        brandService.save(brand);
        brand = brandService.getById(brand.getId());
        return Result.success("品牌新增成功", brand);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Brand brand) {
        brandService.updateById(brand);
        brand = brandService.getById(brand.getId());
        return Result.success("品牌编辑成功", brand);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        brandService.removeById(id);
        return Result.success("品牌删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Brand brand = brandService.getById(id);
        return Result.success("", brand);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Brand> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Brand::getName, searchtext);
        // 可扩展：添加其他字段的模糊查询
        // queryWrapper.like(Brand::getImage, searchtext);
        
        page = brandService.page(page, queryWrapper);
        return Result.success("", page);
    }
}