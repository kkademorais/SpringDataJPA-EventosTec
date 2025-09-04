package com.eventostec.api.domain.address;


public record AddressResponseDTO(
        String uf,
        String city,
        String event
) {
    public AddressResponseDTO(Address address){
        this(address.getUf(), address.getCity(), address.getEvent());
    }
}
