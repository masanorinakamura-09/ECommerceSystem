package com.ec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ec.entity.Address;
import com.ec.repository.AddressRepository;

@Service
public class AddressService {
    private final AddressRepository addressrepository;

    public AddressService(AddressRepository addressrepository) {
        super();
        this.addressrepository = addressrepository;
    }

    public Address getPriorityAddress(Integer id) {
        return  addressrepository.findByCustomerIdAndPriority(id, true);
    }

    public Optional<Address> getAddress(Integer id) {
        return addressrepository.findById(id);
    }

    public void saveAddress(Address address) {
        addressrepository.save(address);
    }

    public boolean existsAddress(Integer id,String code) {
        return addressrepository.existsByCustomerIdAndPostCode(id, code);
    }

    public List<Address> getAddressList(Integer id){
        return addressrepository.findByCustomerId(id);
    }
}
