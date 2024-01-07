package com.example.softwareengineercourses.controller;

import com.example.softwareengineercourses.mybatis.pojo.Employee;
import com.example.softwareengineercourses.mybatis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeService service;



    @RequestMapping("getAll")
    List<Employee> getAll(){
       return service.list();
    }

    @RequestMapping("getById")
    Employee getById(@RequestBody Employee employee){
        return service.getById(employee.getId());
    }

    @RequestMapping("updateById")
    boolean updateById(@RequestBody Employee employee){
        return service.updateById(employee);
    }

    @RequestMapping("login")
    String login(@RequestBody Employee employee){
        String loginError = "login failed";
        Employee employeeT = service.getById(employee.getId());
        if (employeeT.getPassword().equals(employee.getPassword())){
            return employeeT.getOccupation();
        }
        else return loginError;
    }

    @RequestMapping("getStoreEmployee")
    List<Employee> getStoreEmployee(@RequestBody Employee employee){
        String storeId = service.getById(employee.getId()).getAffiliatedStores();
        Map<String, Object> employeeMap = new HashMap<>();
        employeeMap.put("store_id",storeId);
        return service.listByMap(employeeMap);
    }
}
