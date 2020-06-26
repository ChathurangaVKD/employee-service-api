package com.dasun.employeedemo.repo;

import com.dasun.employeedemo.entity.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepo extends JpaRepository<FamilyMember, Long> {
}
