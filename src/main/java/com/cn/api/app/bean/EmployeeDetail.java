package com.cn.api.app.bean;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class EmployeeDetail {
    private String name;
    private double monthlySalary;
    private int age;
}
