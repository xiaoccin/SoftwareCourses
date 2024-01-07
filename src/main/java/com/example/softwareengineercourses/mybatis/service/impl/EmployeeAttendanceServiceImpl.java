package com.example.softwareengineercourses.mybatis.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.EmployeeAttendanceMapper;
import com.example.softwareengineercourses.mybatis.pojo.EmployeeAttendance;
import com.example.softwareengineercourses.mybatis.service.EmployeeAttendanceService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAttendanceServiceImpl extends ServiceImpl<EmployeeAttendanceMapper, EmployeeAttendance> implements EmployeeAttendanceService{
}
