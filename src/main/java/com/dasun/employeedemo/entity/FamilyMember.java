package com.dasun.employeedemo.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity(name = "FAMILY_MEMBER")
public class FamilyMember extends Base{
    String name;
    Long age;
    String relationShip;
}
