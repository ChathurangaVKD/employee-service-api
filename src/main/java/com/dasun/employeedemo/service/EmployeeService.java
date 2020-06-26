package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Employee;
import com.dasun.employeedemo.entity.FamilyMember;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee update(Long id, Employee employee);

    Employee get(Long id);

    void delete(Long id);

    List<Employee> getAll();

    Employee addFamilyMember(Long id, FamilyMember familyMember);

    Employee deleteFamilyMember(Long id, Long familyMemberId);
}
