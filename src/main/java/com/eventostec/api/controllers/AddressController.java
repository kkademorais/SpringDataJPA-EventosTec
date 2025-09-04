package com.eventostec.api.controllers;


import com.eventostec.api.domain.address.AddressRequestDTO;
import com.eventostec.api.domain.address.AddressResponseDTO;
import com.eventostec.api.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public ResponseEntity addAddress(@RequestBody @Valid AddressRequestDTO addressRequestDTO){
        this.addressService.addAddress(addressRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<AddressResponseDTO>> getAddress(){
        return ResponseEntity.ok(this.addressService.getAddress());
    }



}
