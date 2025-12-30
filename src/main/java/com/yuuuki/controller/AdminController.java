package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Admin;
import com.yuuuki.service.AdminService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/")
    public Result add(@RequestBody Admin admin) {
        adminService.save(admin);
        admin = adminService.getById(admin.getId());
        return Result.success("管理员新增成功", admin);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Admin admin) {
        adminService.updateById(admin);
        admin = adminService.getById(admin.getId());
        return Result.success("管理员编辑成功", admin);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        adminService.removeById(id);
        return Result.success("管理员删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Admin admin = adminService.getById(id);
        return Result.success("", admin);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Admin::getAdminname, searchtext);
        queryWrapper.like(Admin::getRealname, searchtext);
        page = adminService.page(page, queryWrapper);
        return Result.success("", page);
    }
}