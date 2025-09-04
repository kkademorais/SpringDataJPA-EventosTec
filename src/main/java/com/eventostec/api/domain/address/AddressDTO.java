package com.eventostec.api.domain.address;

import jakarta.validation.constraints.NotNull;

public record AddressDTO(
        @NotNull
        String uf,
        @NotNull
        String city
) {}
