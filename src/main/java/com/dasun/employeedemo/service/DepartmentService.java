package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Department;

import java.util.List;

public interface DepartmentService {

    Department create(Department department);

    Department update(Long id, Department department);

    Department get(Long id);

    void delete(Long id);

    List<Department> getAll();
}
