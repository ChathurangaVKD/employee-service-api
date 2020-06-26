package com.dasun.employeedemo.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;

@Data
@Entity(name = "EMPLOYEE_TYPE")
public class EmployeeType extends Base{
    @NaturalId
    String name;
}
