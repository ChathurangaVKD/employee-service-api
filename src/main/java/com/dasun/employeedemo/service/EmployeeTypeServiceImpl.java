package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.EmployeeType;
import com.dasun.employeedemo.repo.EmployeeTypeRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    private EmployeeTypeRepo repo;

    public EmployeeTypeServiceImpl(EmployeeTypeRepo repo) {
        this.repo = repo;
    }

    @Override
    public EmployeeType create(EmployeeType employeeType) {
        return repo.save(employeeType);
    }

    @Override
    public EmployeeType update(Long id, EmployeeType employeeType) {
        EmployeeType oldEmployeeType = repo.findById(id).orElse(employeeType);
        if(employeeType.getName() != null){
            oldEmployeeType.setName(employeeType.getName());
        }
        return repo.save(oldEmployeeType);
    }

    @Override
    public EmployeeType get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " EmployeeType Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<EmployeeType> getAll() {
        return repo.findAll();
    }
}
