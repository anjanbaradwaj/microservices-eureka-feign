package com.mylearnings.addressservice.service;

import com.mylearnings.addressservice.entity.Address;
import com.mylearnings.addressservice.repository.AddressRepo;
import com.mylearnings.addressservice.response.AddressResponse;
import com.netflix.discovery.converters.Auto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse findAddressByEmployeeId(int employeeId){
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
        AddressResponse addressResponse = modelMapper.map(addressByEmployeeId, AddressResponse.class);
        return addressResponse;
    }
}
