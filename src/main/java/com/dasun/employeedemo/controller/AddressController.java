package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.Address;
import com.dasun.employeedemo.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private AddressService service;

    public AddressController(AddressService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/address")
    public Address create(@RequestBody Address address) {
        return service.create(address);
    }

    @PutMapping(path = "/api/address/{id}")
    public Address update(@PathVariable("id") Long id, @RequestBody Address address) {
        return service.update(id, address);
    }

    @GetMapping(path = "/api/address/{id}")
    public Address get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/address/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/address/all")
    public List<Address> getAll() {
        return service.getAll();
    }
}
