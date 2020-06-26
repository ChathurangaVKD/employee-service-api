package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepo extends JpaRepository<EmployeeType, Long> {
}
