package com.dasun.employeedemo.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;

@Data
@Entity(name = "DEPARTMENT")
public class Department extends Base {

    String name;
    @NaturalId
    String code;

}
