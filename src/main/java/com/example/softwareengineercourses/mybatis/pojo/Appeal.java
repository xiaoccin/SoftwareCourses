package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("attendance_appeal")
public class Appeal {
    @TableField("employee_id")
    private String employeeId;

    @TableField("employee_name")
    private String name;

    @TableField("attendance_date")
    private String attendanceDate;

    @TableField("type")
    private String type;

    @TableField("status")
    private String status;


}
