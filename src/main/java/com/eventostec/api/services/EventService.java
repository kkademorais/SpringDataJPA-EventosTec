package com.eventostec.api.services;

import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.domain.event.EventResponseDTO;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.data.domain.*;
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

        // Implementando pagination
    public List<EventResponseDTO> getEventList(int pageNumber, int pageSize){
        Pageable eventPageable = PageRequest.of(pageNumber, pageSize,Sort.by("title"));
        return eventRepository
                .findAll(eventPageable)
                .stream()
                .map(event -> new EventResponseDTO(event))
                .toList();
    }

    public void updateEvent(EventRequestDTO eventRequestDTO){
        Event eventUpdate = new Event(eventRequestDTO);
        eventUpdate.setId(this.eventRepository.findAll()
                .stream().filter(event -> event.getTitle().equals(eventUpdate.getTitle()))
                .findFirst().get().getId());
        this.eventRepository.save(eventUpdate);
    }

    public void deleteEventByTitle(String title){
        Event eventDelete = this.eventRepository.findAll()
                .stream()
                .filter(event -> event.getTitle().equals(title))
                .findFirst()
                .get();

        this.eventRepository.delete(eventDelete);
    }


}
