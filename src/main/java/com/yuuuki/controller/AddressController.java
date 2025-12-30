package com.yuuuki.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuuuki.bean.Address;
import com.yuuuki.service.AddressService;
import com.yuuuki.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/")
    public Result add(@RequestBody Address address) {
        addressService.save(address);
        address = addressService.getById(address.getId());
        return Result.success("地址新增成功", address);
    }

    @PutMapping("/")
    public Result edit(@RequestBody Address address) {
        addressService.updateById(address);
        address = addressService.getById(address.getId());
        return Result.success("地址编辑成功", address);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        addressService.removeById(id);
        return Result.success("地址删除成功");
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Address address = addressService.getById(id);
        return Result.success("", address);
    }

    @GetMapping("/")
    public Result getPage(Page page, @RequestParam("searchtext") String searchtext) {
        LambdaQueryWrapper<Address> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.like(Address::getDetailAddress, searchtext);
        queryWrapper.like(Address::getRecipient, searchtext);
        page = addressService.page(page, queryWrapper);
        return Result.success("", page);
    }
}