package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.Employee;
import com.dasun.employeedemo.entity.FamilyMember;
import com.dasun.employeedemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/employee")
    public Employee create(@RequestBody Employee employee) {
        return service.create(employee);
    }

    @PutMapping(path = "/api/employee/{id}")
    public Employee update(@PathVariable("id") Long id, @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @GetMapping(path = "/api/employee/{id}")
    public Employee get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/employee/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/employee/all")
    public List<Employee> getAll() {
        return service.getAll();
    }

    @PostMapping(path = "/api/employee/{id}/familymember")
    public Employee addFamilyMember(@PathVariable("id") Long id, @RequestBody FamilyMember familyMember) {
        return service.addFamilyMember(id, familyMember);
    }

    @DeleteMapping(path = "/api/employee/{id}/familymember/{familyMemberId}")
    public Employee addFamilyMember(@PathVariable("id") Long id, @PathVariable("familyMemberId") Long familyMemberId) {
        return service.deleteFamilyMember(id, familyMemberId);
    }
}
