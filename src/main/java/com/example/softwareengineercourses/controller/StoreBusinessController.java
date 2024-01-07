package com.example.softwareengineercourses.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.softwareengineercourses.mybatis.pojo.Schedule;
import com.example.softwareengineercourses.mybatis.pojo.StoreBusiness;
import com.example.softwareengineercourses.mybatis.service.StoreBusinessService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Wrapper;
import java.util.*;

@RestController
@RequestMapping("storeBusiness")

public class StoreBusinessController {

    @Autowired
    private StoreBusinessService service;

    @RequestMapping("getAll")
    public List<StoreBusiness> getAll(){
        return service.list();
    }

    @RequestMapping("getById")
    public List<StoreBusiness> getById(@RequestBody StoreBusiness storeBusiness){
        Map<String ,Object> objectMap = new HashMap<>();
        objectMap.put("store_ID",storeBusiness.getId());
        return service.listByMap(objectMap);
    }

    @RequestMapping("updateById")
    public boolean updateById(@RequestBody StoreBusiness storeBusiness){
        return service.updateById(storeBusiness);
    }

    /**
     * 对未来一天的预测
     * @param storeBusiness
     * @return
     */
    @RequestMapping("forecastBusiness")
    public StoreBusiness forecastBusiness(@RequestBody StoreBusiness storeBusiness){
        Map<String ,Object> objectMap = new HashMap<>();
        objectMap.put("store_ID",storeBusiness.getId());
        List<StoreBusiness> storeBusinesses =  service.listByMap(objectMap);
        Integer sumPassengerFlow = 0;
        Float sumSales = 0.0F;
        for(StoreBusiness store : storeBusinesses){
            sumPassengerFlow += store.getPassengerFlow();
            sumSales += store.getSales();
        }
        StoreBusiness forecast = new StoreBusiness();
        forecast.setId(storeBusiness.getId());
        forecast.setSales(sumSales/storeBusinesses.size());
        forecast.setPassengerFlow(sumPassengerFlow/storeBusinesses.size());
        forecast.setTime(storeBusiness.getTime());
        return forecast;
    }

    /**
     * 对未来三天的预测
     * @param storeBusiness
     * @return
     */
    @RequestMapping("forecastBusinessThree")
    public List<StoreBusiness> forecastBusinessThree(@RequestBody StoreBusiness storeBusiness){
        Map<String ,Object> objectMap = new HashMap<>();
        objectMap.put("store_ID",storeBusiness.getId());
        List<StoreBusiness> storeBusinesses =  service.listByMap(objectMap);
        Integer sumPassengerFlow = 0;
        Float sumSales = 0.0F;
        for(StoreBusiness store : storeBusinesses){
            sumPassengerFlow += store.getPassengerFlow();
            sumSales += store.getSales();
        }
        Float avgSales = sumSales/storeBusinesses.size();
        Integer avgPassengerFlow = sumPassengerFlow/storeBusinesses.size();
        List<StoreBusiness> forecastBusiness = new ArrayList<>();
        Calendar t = Calendar.getInstance();
        t.setTime(storeBusiness.getTime());
        Random rand = new Random();
        for (int i =0;i<3;i++){
            int rand_p = rand.nextInt(10);
            Float rand_s = rand.nextFloat(10F);
            StoreBusiness storeBusinessT = new StoreBusiness();
            t.add(Calendar.DATE,i);
            storeBusinessT.setTime( t.getTime());
            storeBusinessT.setId(storeBusiness.getId());
            storeBusinessT.setSales(avgSales+rand_s);
            storeBusinessT.setPassengerFlow(avgPassengerFlow+rand_p);
            forecastBusiness.add(storeBusinessT);
        }
        return forecastBusiness;
    }

    @RequestMapping("forecastBusinessWeek")
    public List<StoreBusiness> forecastBusinessWeek(@RequestBody StoreBusiness storeBusiness){
        Map<String ,Object> objectMap = new HashMap<>();
        objectMap.put("store_ID",storeBusiness.getId());
        List<StoreBusiness> storeBusinesses =  service.listByMap(objectMap);
        Integer sumPassengerFlow = 0;
        Float sumSales = 0.0F;
        for(StoreBusiness store : storeBusinesses){
            sumPassengerFlow += store.getPassengerFlow();
            sumSales += store.getSales();
        }
        Float avgSales = sumSales/storeBusinesses.size();
        Integer avgPassengerFlow = sumPassengerFlow/storeBusinesses.size();
        List<StoreBusiness> forecastBusiness = new ArrayList<>();
        Calendar t = Calendar.getInstance();
        t.setTime(storeBusiness.getTime());
        Random rand = new Random();
        for (int i =0;i<7;i++){
            int rand_p = rand.nextInt(10);
            Float rand_s = rand.nextFloat(10F);
            StoreBusiness storeBusinessT = new StoreBusiness();
            t.add(Calendar.DATE,i);
            storeBusinessT.setTime( t.getTime());
            storeBusinessT.setId(storeBusiness.getId());
            storeBusinessT.setSales(avgSales+rand_s);
            storeBusinessT.setPassengerFlow(avgPassengerFlow+rand_p);
            forecastBusiness.add(storeBusinessT);
        }
        return forecastBusiness;
    }



    @RequestMapping("deleteById")
    public boolean deleteById(@RequestBody StoreBusiness storeBusiness){
        Map<String,Object> removeMap = new HashMap<>();
        removeMap.put("store_ID",storeBusiness.getId());
        removeMap.put("date",storeBusiness.getTime());
        return  service.removeByMap(removeMap);
    }

}
