package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.EmployeeType;

import java.util.List;

public interface EmployeeTypeService {

    EmployeeType create(EmployeeType employeeType);

    EmployeeType update(Long id, EmployeeType employeeType);

    EmployeeType get(Long id);

    void delete(Long id);

    List<EmployeeType> getAll();
}
