package com.eventostec.api.services;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.domain.event.EventResponseDTO;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository){this.eventRepository = eventRepository;}


    public void addEvent(EventRequestDTO eventRequestDTO){
        Event eventDTO = new Event(eventRequestDTO);
        eventRepository.save(eventDTO);
    }

    public List<EventResponseDTO> getEventList(){
        return eventRepository
                .findAll()
                .stream()
                .map(event -> new EventResponseDTO(event))
                .toList();
    }


}
