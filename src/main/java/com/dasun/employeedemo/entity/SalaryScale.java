package com.dasun.employeedemo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "SALARY_SCALE")
public class SalaryScale extends Base {
    String name;
    String code;
    Double amount;
}
