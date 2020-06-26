package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeRepo extends JpaRepository<Office, Long> {
}
