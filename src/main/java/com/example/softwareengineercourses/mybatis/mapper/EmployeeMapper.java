package com.example.softwareengineercourses.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.softwareengineercourses.mybatis.pojo.Employee;
import com.example.softwareengineercourses.mybatis.pojo.ScheduleRules;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {


}
