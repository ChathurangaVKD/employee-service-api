package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.Address;
import com.dasun.employeedemo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department, Long> {
}
