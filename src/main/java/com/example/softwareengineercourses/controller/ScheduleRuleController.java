package com.example.softwareengineercourses.controller;

import com.example.softwareengineercourses.mybatis.pojo.ScheduleRules;
import com.example.softwareengineercourses.mybatis.service.ScheduleRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("scheduleRule")
public class ScheduleRuleController {

    @Autowired
    ScheduleRulesService scheduleRulesService;


    @RequestMapping("getAll")
    public List<ScheduleRules> getAll(){
        return scheduleRulesService.list();
    }

    @RequestMapping("updateById")
    public boolean updateById(@RequestBody ScheduleRules scheduleRules){
        return  scheduleRulesService.updateById(scheduleRules);
    }

    @RequestMapping("deleteById")
    public boolean deleteById(@RequestBody ScheduleRules scheduleRules){
        return  scheduleRulesService.removeById(scheduleRules);
    }

    @RequestMapping("addRule")
    public boolean addRule(@RequestBody ScheduleRules scheduleRules){
        return scheduleRulesService.save(scheduleRules);
    }
}
