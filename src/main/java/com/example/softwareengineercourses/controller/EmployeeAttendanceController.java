package com.example.softwareengineercourses.controller;

import com.example.softwareengineercourses.mybatis.pojo.Appeal;
import com.example.softwareengineercourses.mybatis.pojo.Employee;
import com.example.softwareengineercourses.mybatis.pojo.EmployeeAttendance;
import com.example.softwareengineercourses.mybatis.service.AppealService;
import com.example.softwareengineercourses.mybatis.service.EmployeeAttendanceService;
import com.example.softwareengineercourses.mybatis.service.EmployeeService;
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
    @Autowired
    private AppealService appealService;
    @Autowired
    private EmployeeService employeeService;

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

    /**
     * 员工对打卡信息进行申诉
     * @param attendance 打卡信息
     * @return 申诉结果
     */
    @RequestMapping("appealAttendance")
    boolean appealAttendance(@RequestBody EmployeeAttendance attendance){
        Employee employee = employeeService.getById(attendance.getId());
        Appeal appeal = new Appeal();
        appeal.setName(employee.getName());
        appeal.setEmployeeId(employee.getId());
        appeal.setAttendanceDate(attendance.getDate().toString());
        appeal.setType(attendance.getType());
        appeal.setStatus(attendance.getStatus());
        return appealService.save(appeal);
    }

    /**
     * 管理员获得所有的申诉信息
     * @return 申诉信息
     */

    @RequestMapping("getAllAppeal")
    List<Appeal> getAllAppeal(){
        return appealService.list();
    }
}
