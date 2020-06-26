package com.dasun.employeedemo.service;

import com.dasun.employeedemo.entity.Address;
import com.dasun.employeedemo.repo.AddressRepo;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepo repo;

    public AddressServiceImpl(AddressRepo repo) {
        this.repo = repo;
    }

    @Override
    public Address create(Address address) {
        return repo.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        Address oldAddress = repo.findById(id).orElse(address);
        if (address.getCity() != null) {
            oldAddress.setCity(address.getCity());
        }
        if (address.getCountry() != null) {
            oldAddress.setCountry(address.getCountry());
        }
        if (address.getNo() != null) {
            oldAddress.setNo(address.getNo());
        }
        if (address.getLane1() != null) {
            oldAddress.setLane1(address.getLane1());
        }
        if (address.getLane2() != null) {
            oldAddress.setLane2(address.getLane2());
        }
        if (address.getPostalCode() != null) {
            oldAddress.setPostalCode(address.getPostalCode());
        }
        return repo.save(oldAddress);
    }

    @Override
    public Address get(Long id) {
        return repo.findById(id).orElseThrow(() -> new EntityNotFoundException(id + " Address Not Found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<Address> getAll() {
        return repo.findAll();
    }
}
