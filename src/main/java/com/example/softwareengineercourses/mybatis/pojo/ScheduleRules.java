package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Time;

@Data
@TableName("ScheduleRules")
public class ScheduleRules {
    //门店id
    @TableId("id")
    private String id;
    //规则类型
    private String ruleType;

    //开店时间
    private Time openingHours;
    //关店时间
    private Time closeHours;
}
