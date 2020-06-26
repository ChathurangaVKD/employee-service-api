package com.dasun.employeedemo.entity;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity(name = "EMPLOYEE")
public class Employee extends Base{

    @NaturalId
    String username;
    String firstName;
    String lastName;
    @NaturalId
    String email;
    Long age;
    Long mobile;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    EmployeeType type;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    Employee supervisor;

    @OneToOne(cascade = CascadeType.ALL)
    Address address;


    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH} , fetch = FetchType.EAGER)
    Department department;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    Office office;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    SalaryScale salaryScale;

    @OneToMany(cascade = CascadeType.ALL)
    List<FamilyMember> familyMembers = new ArrayList<>();

}
