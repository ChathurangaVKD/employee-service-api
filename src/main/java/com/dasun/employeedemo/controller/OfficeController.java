package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.Office;
import com.dasun.employeedemo.service.OfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OfficeController {

    private OfficeService service;

    public OfficeController(OfficeService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/office")
    public Office create(@RequestBody Office office) {
        return service.create(office);
    }

    @PutMapping(path = "/api/office/{id}")
    public Office update(@PathVariable("id") Long id, @RequestBody Office office) {
        return service.update(id, office);
    }

    @GetMapping(path = "/api/office/{id}")
    public Office get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/office/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/office/all")
    public List<Office> getAll() {
        return service.getAll();
    }
}
