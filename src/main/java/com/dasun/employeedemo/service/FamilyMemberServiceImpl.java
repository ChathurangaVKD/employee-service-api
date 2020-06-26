package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.FamilyMember;
import com.dasun.employeedemo.repo.FamilyMemberRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private FamilyMemberRepo repo;

    public FamilyMemberServiceImpl(FamilyMemberRepo repo) {
        this.repo = repo;
    }

    @Override
    public FamilyMember create(FamilyMember familyMember) {
        return repo.save(familyMember);
    }

    @Override
    public FamilyMember update(Long id, FamilyMember familyMember) {
        FamilyMember oldFamilyMember = repo.findById(id).orElse(familyMember);
        if(familyMember.getAge() != null){
            oldFamilyMember.setAge(familyMember.getAge());
        }
        if(familyMember.getName() != null){
            oldFamilyMember.setName(familyMember.getName());
        }
        if(familyMember.getRelationShip() != null){
            oldFamilyMember.setRelationShip(familyMember.getRelationShip());
        }
        return repo.save(oldFamilyMember);
    }

    @Override
    public FamilyMember get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " FamilyMember Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<FamilyMember> getAll() {
        return repo.findAll();
    }
}
