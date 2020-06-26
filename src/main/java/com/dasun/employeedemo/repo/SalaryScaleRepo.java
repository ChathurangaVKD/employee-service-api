package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.SalaryScale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryScaleRepo extends JpaRepository<SalaryScale, Long> {
}
