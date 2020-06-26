package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Address;

import java.util.List;

public interface AddressService {

    Address create(Address address);

    Address update(Long id, Address address);

    Address get(Long id);

    void delete(Long id);

    List<Address> getAll();
}
