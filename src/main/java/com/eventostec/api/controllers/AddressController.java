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

    @PutMapping
    public ResponseEntity updateAddress(@RequestBody @Valid AddressRequestDTO addressRequestDTO){
        this.addressService.updateAddress(addressRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{event}")
    public ResponseEntity deleteAddressByEvent(@PathVariable(name = "event") String event){
        this.addressService.deleteAddressByEvent(event);
        return ResponseEntity.ok().build();
    }

}
