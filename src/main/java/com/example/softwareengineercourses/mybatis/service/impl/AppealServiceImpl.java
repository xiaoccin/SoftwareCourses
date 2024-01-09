package com.example.softwareengineercourses.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.AppealMapper;
import com.example.softwareengineercourses.mybatis.pojo.Appeal;
import com.example.softwareengineercourses.mybatis.service.AppealService;
import org.springframework.stereotype.Service;

@Service
public class AppealServiceImpl extends ServiceImpl<AppealMapper, Appeal> implements AppealService {
}
