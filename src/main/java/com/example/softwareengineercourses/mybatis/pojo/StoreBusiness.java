package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("store_business")
public class StoreBusiness {
    //门店id
    @TableId("store_ID")
    String id;
    //时间
    @TableField("date")
    Date time;
    //客流量
    @TableField("passenger_volume")
    Integer passengerFlow;
    //销售额
    @TableField("sales_volume")
    Float sales;
}
