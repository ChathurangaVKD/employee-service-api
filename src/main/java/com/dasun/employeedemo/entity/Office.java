package com.dasun.employeedemo.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Data
@Entity(name = "OFFICE")
public class Office extends Base {
    String name;
    @NaturalId
    String code;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;
}
