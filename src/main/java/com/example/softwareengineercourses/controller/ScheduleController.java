package com.example.softwareengineercourses.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.softwareengineercourses.mybatis.pojo.*;
import com.example.softwareengineercourses.mybatis.service.EmployeeService;
import com.example.softwareengineercourses.mybatis.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.*;

@RestController
@RequestMapping("schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired


    @RequestMapping("getAll")
    public List<ScheduleInfo> getAll(){
        List<Schedule> schedules =  scheduleService.list();
        List<ScheduleInfo> scheduleInfos = new ArrayList<>();
        for (Schedule s:schedules
             ) {
            ScheduleInfo temp = new ScheduleInfo();
            temp.setName(employeeService.getById(s.getEmployeeId()).getName());
            temp.setDate(s.getDate());
            temp.setTimeSlot(s.getTimeSlot());
            scheduleInfos.add(temp);
        }
        return scheduleInfos;
    }

    //员工个人排班安排
    @RequestMapping("getById")
    public List<Schedule> getById(@RequestBody Employee employee){
        Map<String, Object> map = new HashMap<>();
        map.put("employee_ID",employee.getId());
        return scheduleService.listByMap(map);
    }

    //店面排班安排
    @RequestMapping("getByStoreId")
    public List<Schedule> getByStoreId(@RequestBody Store store){
        Map<String, Object> map = new HashMap<>();
        map.put("store_ID",store.getId());
        return scheduleService.listByMap(map);
    }

    //根据店面时间段修改人员值班
    @RequestMapping("updateById")
    public boolean updateById(@RequestBody Schedule schedule){
        UpdateWrapper<Schedule> wrapper = new UpdateWrapper<>();
        Map<String ,Object> objectMap = new HashMap<>();
        System.out.println(schedule);
        objectMap.put("date",schedule.getDate());
        objectMap.put("time_slot",schedule.getTimeSlot());
        objectMap.put("store_ID",schedule.getStoreId());
        wrapper.allEq(objectMap,false);
        return scheduleService.update(schedule,wrapper);
    }
    //按日查询排班表
    @RequestMapping("getByDate")
    public List<ScheduleInfo> getScheduleInfoByDay(@RequestBody Schedule schedule){
        Map<String,Object> map = new HashMap<>();
        map.put("date",schedule.getDate());
        List<Schedule> schedules = scheduleService.listByMap(map);
        List<ScheduleInfo> infos = new ArrayList<>();
        for (Schedule temp : schedules){
            ScheduleInfo t = new ScheduleInfo();
            t.setDate(temp.getDate());
            t.setTimeSlot(temp.getTimeSlot());
            Employee employee = employeeService.getById(temp.getEmployeeId());
            t.setName(employee.getName());
            t.setOccupation(employee.getOccupation());
            t.setStoreId(schedule.getStoreId());
            infos.add(t);
        }
        return infos;
    }

    /**
     * 自动排班
     * @param store 所需排班的store
     * @return scheduleInfos
     */
    @RequestMapping("autoSchedule")
    public List<ScheduleInfo> autoSchedule(@RequestBody Store store){
        Map<String,Object> map = new HashMap<>();
        map.put("store_ID",store.getId());
        List<Employee> employees = employeeService.listByMap(map);
        System.out.println(employees);
        List<ScheduleInfo> scheduleInfos = new ArrayList<>();
        String timeSlot[] = {"上午","下午","晚上"};
        for(int i=1;i<=7;i++){
            for (int j=0;j<3;j++){
                ScheduleInfo scheduleInfo = new ScheduleInfo();
                scheduleInfo.setStoreId(store.getId());
                scheduleInfo.setName(employees.get(j).getName());
                scheduleInfo.setDate("2024-01-0"+i);
                scheduleInfo.setTimeSlot(timeSlot[j]);
                scheduleInfo.setOccupation(employees.get(j).getOccupation());
                scheduleInfos.add(scheduleInfo);
            }
        }
        return scheduleInfos;
    }

    @RequestMapping("addSchedule")
    public boolean addSchedule(@RequestBody Schedule schedule){
        return  scheduleService.save(schedule);
    }



}
