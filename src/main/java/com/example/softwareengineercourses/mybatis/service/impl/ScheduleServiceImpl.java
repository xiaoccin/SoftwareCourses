package com.example.softwareengineercourses.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.ScheduleMapper;
import com.example.softwareengineercourses.mybatis.pojo.Schedule;
import com.example.softwareengineercourses.mybatis.service.ScheduleService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl extends ServiceImpl<ScheduleMapper, Schedule> implements ScheduleService {
}
