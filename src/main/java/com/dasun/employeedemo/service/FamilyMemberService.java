package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.FamilyMember;

import java.util.List;

public interface FamilyMemberService {

    FamilyMember create(FamilyMember familyMember);

    FamilyMember update(Long id, FamilyMember familyMember);

    FamilyMember get(Long id);

    void delete(Long id);

    List<FamilyMember> getAll();
}
