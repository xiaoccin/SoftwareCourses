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
    @TableId("store_id")
    private String id;
    //规则类型
    @TableField("rule_type")
    private String ruleType;

    //开店时间
    @TableField("open_time")
    private Time openingHours;
    //关店时间
    @TableField("close_time")
    private Time closeHours;
}
