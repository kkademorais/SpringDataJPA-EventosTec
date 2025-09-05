package com.eventostec.api.domain.event;

import com.eventostec.api.domain.address.Address;

import java.time.LocalDateTime;
import java.util.Date;

public record EventResponseDTO(
        String title,
        String date,
        //@NotNull -> Se for presencial
        String address,
        Boolean remote,
        //@NotNull -> Se for remoto
        String event_url,
        String image_url,
        String description
) {
    public EventResponseDTO(Event event){
        this(event.getTitle(), event.getDateFormatado(), event.getAddress(), event.isRemote(), event.getEvent_url(), event.getImage_url(), event.getDescription());
    }
}
