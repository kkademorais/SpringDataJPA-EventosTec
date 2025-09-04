package com.eventostec.api.services;

import com.eventostec.api.domain.address.Address;
import com.eventostec.api.domain.address.AddressRequestDTO;
import com.eventostec.api.domain.address.AddressResponseDTO;
import com.eventostec.api.repositories.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository){this.addressRepository = addressRepository;}

    public void addAddress(AddressRequestDTO addressRequestDTO){
        Address addressAdd = new Address(addressRequestDTO);
        this.addressRepository.save(addressAdd);
    }

    public List<AddressResponseDTO> getAddress(){
        return this.addressRepository
                .findAll()
                .stream()
                .map(address -> new AddressResponseDTO(address))
                .toList();
    }




}
