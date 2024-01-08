package com.example.softwareengineercourses.controller;

import com.example.softwareengineercourses.mybatis.pojo.Employee;
import com.example.softwareengineercourses.mybatis.pojo.EmployeeAttendance;
import com.example.softwareengineercourses.mybatis.service.EmployeeAttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("EmployeeAttendance")
public class EmployeeAttendanceController {
    @Autowired
    private EmployeeAttendanceService attendanceService;

    @RequestMapping("getAll")
    List<EmployeeAttendance> getAll(){
        return attendanceService.list();
    }

    @RequestMapping("getById")
    List<EmployeeAttendance> getById(@RequestBody Employee employee){
        String employeeId = employee.getId();
        Map<String,Object> objectMap = new HashMap<>();
        objectMap.put("employee_ID",employeeId);
        return attendanceService.listByMap(objectMap);
    }

    @RequestMapping("updateById")
    boolean updateById(@RequestBody EmployeeAttendance attendance){
        return attendanceService.updateById(attendance);
    }

    @RequestMapping("addEmployeeAttendance")
    boolean addEmployeeAttendance(@RequestBody EmployeeAttendance attendance){
        return  attendanceService.save(attendance);
    }
}
