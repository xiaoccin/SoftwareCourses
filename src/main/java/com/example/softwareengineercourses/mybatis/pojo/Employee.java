package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;


@Data
@TableName("employee_info")
public class Employee {
    //姓名
    @TableField("employee_name")
    private String name;
    //id
    @TableId("employee_ID")
    private String id;
    //联系方式
    @TableField("phone")
    private String telephone;
    //职位
    @TableField("position")
    private String occupation;
    //所属门店
    @TableField("store_ID")
    private String affiliatedStores;
    //偏好
    @TableField("preference_value")
    private String preference;

    @TableField("password")
    private String password;
}
