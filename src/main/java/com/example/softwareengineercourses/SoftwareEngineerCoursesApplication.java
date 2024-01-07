package com.example.softwareengineercourses;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.softwareengineercourses.mybatis.mapper")
@SpringBootApplication
public class SoftwareEngineerCoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareEngineerCoursesApplication.class, args);
    }

}
