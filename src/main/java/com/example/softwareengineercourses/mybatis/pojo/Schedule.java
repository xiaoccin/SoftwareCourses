package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("schedule")
public class Schedule {
    //employId
    @TableField("employee_ID")
    String employeeId;
    //storeId
    @TableField("store_ID")
    String storeId;
    //日期
    @TableField("date")
    String date;
    //时间段
    @TableField("time_slot")
    String timeSlot;
    //星期
    @TableField("day_of_week")
    String dayOfWeek;
}
