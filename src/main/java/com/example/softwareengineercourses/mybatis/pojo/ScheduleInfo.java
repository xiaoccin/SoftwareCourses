package com.example.softwareengineercourses.mybatis.pojo;

import lombok.Data;

@Data
public class ScheduleInfo {
    //日期
    String date;
    //时间段
    String timeSlot;
    //姓名
    String name;
    //职位
    String occupation;
    //店面
    String storeId;
}
