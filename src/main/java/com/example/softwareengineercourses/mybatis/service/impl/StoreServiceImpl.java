package com.example.softwareengineercourses.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.StoreMapper;
import com.example.softwareengineercourses.mybatis.pojo.Store;
import com.example.softwareengineercourses.mybatis.service.StoreService;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {
}
