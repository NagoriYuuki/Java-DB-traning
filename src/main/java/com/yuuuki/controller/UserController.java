package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.User;
import com.yuuuki.service.UserService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public Result add(@RequestBody User user){//接收json数据
        userService.save(user);
        user=userService.getById(user.getId());
        return Result.success("数据新增成功",user);
    }
    @PutMapping("/")
    public Result edit(@RequestBody User user){
        userService.updateById(user);
        user=userService.getById(user.getId());
        return Result.success("数据编辑成功",user);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        userService.removeById(id);
        return Result.success("删除数据成功");
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable int id){
        User user=userService.getById(id);
        return Result.success("",user);
    }
    @GetMapping("/")
    public Result getPage(Page page,@RequestParam("searchtext") String searchtext){
        LambdaQueryWrapper<User> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getUsername,searchtext);
        lambdaQueryWrapper.like(User::getNickname,searchtext);
        page = userService.page(page, lambdaQueryWrapper);//page和查询条件
        return Result.success("",page);

    }
}
