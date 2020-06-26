package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.Department;
import com.dasun.employeedemo.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/department")
    public Department create(@RequestBody Department department) {
        return service.create(department);
    }

    @PutMapping(path = "/api/department/{id}")
    public Department update(@PathVariable("id") Long id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @GetMapping(path = "/api/department/{id}")
    public Department get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/department/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/department/all")
    public List<Department> getAll() {
        return service.getAll();
    }
}
