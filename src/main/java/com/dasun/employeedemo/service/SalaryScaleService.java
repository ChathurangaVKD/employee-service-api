package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.SalaryScale;

import java.util.List;

public interface SalaryScaleService {

    SalaryScale create(SalaryScale salaryScale);

    SalaryScale update(Long id, SalaryScale salaryScale);

    SalaryScale get(Long id);

    void delete(Long id);

    List<SalaryScale> getAll();
}
