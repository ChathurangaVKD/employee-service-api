package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.SalaryScale;
import com.dasun.employeedemo.repo.SalaryScaleRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SalaryScaleServiceImpl implements SalaryScaleService {

    private SalaryScaleRepo repo;

    public SalaryScaleServiceImpl(SalaryScaleRepo repo) {
        this.repo = repo;
    }

    @Override
    public SalaryScale create(SalaryScale salaryScale) {
        return repo.save(salaryScale);
    }

    @Override
    public SalaryScale update(Long id, SalaryScale salaryScale) {
        SalaryScale oldSalaryScale = repo.findById(id).orElse(salaryScale);
        if (salaryScale.getAmount() != null) {
            oldSalaryScale.setAmount(salaryScale.getAmount());
        }
        if (salaryScale.getCode() != null) {
            oldSalaryScale.setCode(salaryScale.getCode());
        }
        if (salaryScale.getName() != null) {
            oldSalaryScale.setName(salaryScale.getName());
        }

        return repo.save(oldSalaryScale);
    }

    @Override
    public SalaryScale get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " SalaryScale Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<SalaryScale> getAll() {
        return repo.findAll();
    }
}
