package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.Address;
import com.dasun.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
