package com.dasun.employeedemo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "ADDRESS")
public class Address extends Base {
    String no;
    String lane1;
    String lane2;
    String city;
    Long postalCode;
    String country;
}
