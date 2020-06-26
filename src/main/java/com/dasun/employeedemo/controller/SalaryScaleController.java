package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.SalaryScale;
import com.dasun.employeedemo.service.SalaryScaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalaryScaleController {

    private SalaryScaleService service;

    public SalaryScaleController(SalaryScaleService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/salaryscale")
    public SalaryScale create(@RequestBody SalaryScale salaryscale) {
        return service.create(salaryscale);
    }

    @PutMapping(path = "/api/salaryscale/{id}")
    public SalaryScale update(@PathVariable("id") Long id, @RequestBody SalaryScale salaryscale) {
        return service.update(id, salaryscale);
    }

    @GetMapping(path = "/api/salaryscale/{id}")
    public SalaryScale get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/salaryscale/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/salaryscale/all")
    public List<SalaryScale> getAll() {
        return service.getAll();
    }
}
