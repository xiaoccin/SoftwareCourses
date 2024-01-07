package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Date;

@Data
@TableName("employee_attendance")
public class EmployeeAttendance {
    //employee ID
    @TableId("employee_ID")
    String id;
    //打卡日期
    @TableField("date")
    Date date;
    //打卡类型
    //上班，下班
    @TableField("attendance_type")
    String type;
    //打卡状态
    //早退,迟到,正常
    @TableField("attendance_status")
    String status;
}
