package com.dasun.employeedemo.controller;

import com.dasun.employeedemo.entity.FamilyMember;
import com.dasun.employeedemo.service.FamilyMemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FamilyMemberController {

    private FamilyMemberService service;

    public FamilyMemberController(FamilyMemberService service) {
        this.service = service;
    }

    @PostMapping(path = "/api/familymember")
    public FamilyMember create(@RequestBody FamilyMember familymember) {
        return service.create(familymember);
    }

    @PutMapping(path = "/api/familymember/{id}")
    public FamilyMember update(@PathVariable("id") Long id, @RequestBody FamilyMember familymember) {
        return service.update(id, familymember);
    }

    @GetMapping(path = "/api/familymember/{id}")
    public FamilyMember get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @DeleteMapping(path = "/api/familymember/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping(path = "/api/familymember/all")
    public List<FamilyMember> getAll() {
        return service.getAll();
    }
}
