package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Department;
import com.dasun.employeedemo.repo.DepartmentRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepo repo;

    public DepartmentServiceImpl(DepartmentRepo repo) {
        this.repo = repo;
    }

    @Override
    public Department create(Department department) {
        return repo.save(department);
    }

    @Override
    public Department update(Long id, Department department) {
        Department oldDepartment = repo.findById(id).orElse(department);

        if (department.getCode() != null) {
            oldDepartment.setCode(department.getCode());
        }
        if (department.getName() != null) {
            oldDepartment.setName(department.getName());
        }
        return repo.save(oldDepartment);
    }

    @Override
    public Department get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " Department Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Department> getAll() {
        return repo.findAll();
    }
}
