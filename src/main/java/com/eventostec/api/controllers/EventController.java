package com.eventostec.api.controllers;

import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.domain.event.EventResponseDTO;
import com.eventostec.api.services.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService){
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity addEvent(@RequestBody @Valid EventRequestDTO eventRequestDTO){
        this.eventService.addEvent(eventRequestDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<EventResponseDTO>> getEventList(){
        List<EventResponseDTO> eventResponseDTOList = this.eventService.getEventList();
        return ResponseEntity.ok(eventResponseDTOList);
    }

    @PutMapping
    public ResponseEntity updateEvent(@RequestBody @Valid EventRequestDTO eventRequestDTO){
        this.eventService.updateEvent(eventRequestDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{title}")
    public ResponseEntity deleteEventByTitle(@PathVariable(name = "title") String title){
        this.eventService.deleteEventByTitle(title);
        return ResponseEntity.ok().build();
    }


}
