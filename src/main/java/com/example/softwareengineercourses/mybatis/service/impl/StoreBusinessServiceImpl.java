package com.example.softwareengineercourses.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.StoreBusinessMapper;
import com.example.softwareengineercourses.mybatis.pojo.StoreBusiness;
import com.example.softwareengineercourses.mybatis.service.StoreBusinessService;
import org.springframework.stereotype.Service;

@Service
public class StoreBusinessServiceImpl extends ServiceImpl<StoreBusinessMapper, StoreBusiness> implements StoreBusinessService {
}
