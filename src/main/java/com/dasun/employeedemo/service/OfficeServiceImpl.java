package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Office;
import com.dasun.employeedemo.repo.OfficeRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private OfficeRepo repo;

    public OfficeServiceImpl(OfficeRepo repo) {
        this.repo = repo;
    }

    @Override
    public Office create(Office office) {
        return repo.save(office);
    }

    @Override
    public Office update(Long id, Office office) {
        Office oldOffice = repo.findById(id).orElse(office);
        if(office.getCode() != null){
            oldOffice.setCode(office.getCode());
        }
        if(office.getName() != null){
            oldOffice.setName(office.getName());
        }
        if(office.getAddress() != null){
            oldOffice.setAddress(office.getAddress());
        }
        return repo.save(oldOffice);
    }

    @Override
    public Office get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " Office Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Office> getAll() {
        return repo.findAll();
    }
}
