package com.example.softwareengineercourses.mybatis.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("store_info")
public class Store {
    //门店ID
    @TableId("store_ID")
    private String id;
    //门店姓名
    @TableField("store_name")
    private String name;
    //门店地址
    @TableField("address")
    private String address;
    //门店地址
    @TableField("area")
    private String area;
    //店主
    @TableField("manager")
    private String shopkeeper;
}
