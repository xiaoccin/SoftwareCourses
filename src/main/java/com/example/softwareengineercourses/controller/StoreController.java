package com.example.softwareengineercourses.controller;

import com.example.softwareengineercourses.mybatis.pojo.Store;
import com.example.softwareengineercourses.mybatis.service.StoreService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @RequestMapping("findAll")
    List<Store> findAll(){
        List<Store> list = storeService.list();
        return list;
    }

    @RequestMapping("findById")
    Store findById(@RequestBody Store store){
        Store ans = storeService.getById(store.getId());
        return ans;
    }

    @RequestMapping("updateById")
    boolean updateById(@RequestBody Store store){
        return storeService.updateById(store);
    }

    @RequestMapping("deleteById")
    boolean deleteByuId(@RequestBody Store store){
        return storeService.removeById(store);
    }

    @RequestMapping("addStore")
    boolean addStore(@RequestBody Store store){
        return storeService.save(store);
    }

}
