package com.eventostec.api.services;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.domain.event.EventResponseDTO;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    public void updateEvent(EventRequestDTO eventRequestDTO){

        Event eventUpdate = new Event();
        eventUpdate.updateEvent(eventRequestDTO);

        eventUpdate.setId(this.eventRepository.findAll()
                .stream().filter(event -> event.getTitle().equals(eventUpdate.getTitle()))
                .findFirst().get().getId());

        this.eventRepository.save(eventUpdate);

    }


}
