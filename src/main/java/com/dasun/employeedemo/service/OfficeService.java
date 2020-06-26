package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Office;

import java.util.List;

public interface OfficeService {

    Office create(Office office);

    Office update(Long id, Office office);

    Office get(Long id);

    void delete(Long id);

    List<Office> getAll();
}
