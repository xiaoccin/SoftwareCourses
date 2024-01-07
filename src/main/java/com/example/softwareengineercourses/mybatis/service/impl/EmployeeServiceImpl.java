package com.example.softwareengineercourses.mybatis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.softwareengineercourses.mybatis.mapper.EmployeeMapper;
import com.example.softwareengineercourses.mybatis.pojo.Employee;
import com.example.softwareengineercourses.mybatis.service.EmployeeService;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl  extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {


}
