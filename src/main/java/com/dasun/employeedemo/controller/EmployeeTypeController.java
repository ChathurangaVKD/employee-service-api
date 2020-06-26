package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.EmployeeType;
import com.dasun.employeedemo.service.EmployeeTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeTypeController {

    private EmployeeTypeService service;

    public EmployeeTypeController(EmployeeTypeService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/employeetype")
    public EmployeeType create(@RequestBody EmployeeType employeetype) {
        return service.create(employeetype);
    }

    @PutMapping(path = "/api/employeetype/{id}")
    public EmployeeType update(@PathVariable("id") Long id, @RequestBody EmployeeType employeetype) {
        return service.update(id, employeetype);
    }

    @GetMapping(path = "/api/employeetype/{id}")
    public EmployeeType get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/employeetype/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/employeetype/all")
    public List<EmployeeType> getAll() {
        return service.getAll();
    }
}
