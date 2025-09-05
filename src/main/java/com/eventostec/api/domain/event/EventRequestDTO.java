package com.eventostec.api.domain.event;

import com.eventostec.api.domain.address.Address;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EventRequestDTO(
        @NotNull
        String title,
        @NotNull
        Date date,
        //@NotNull -> Se for presencial
        String address,
        Boolean remote,
        //@NotNull -> Se for remoto
        String event_url,
        String image_url,
        String description
) {}
