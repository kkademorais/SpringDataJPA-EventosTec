package com.eventostec.api.domain.address;

import jakarta.validation.constraints.NotNull;

public record AddressRequestDTO(
        @NotNull
        String uf,
        @NotNull
        String city,
        String event
) {}
