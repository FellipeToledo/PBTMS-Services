package com.pbtms.eventservice.endpoint.controller;

import com.pbtms.core.response.ApiResponse;
import com.pbtms.eventservice.endpoint.dto.EventDto;
import com.pbtms.eventservice.endpoint.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("api/v1/event")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventService eventService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EventDto> createEvent(@Valid @RequestBody EventDto eventDto) {
        EventDto createEventDto = eventService.createEvent(eventDto);
        return new ResponseEntity<>(createEventDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDto> updateEvent(@Valid @RequestBody EventDto eventDto, @PathVariable("id") long id) {
        EventDto updatedEvent = this.eventService.updateEvent(eventDto, id);
        return ResponseEntity.ok(updatedEvent);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEvent(@PathVariable("id") long id) {
        this.eventService.deleteEvent(id);
        return new ResponseEntity<>(new ApiResponse("Event deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EventDto>> getAllEvents() {
        return ResponseEntity.ok(this.eventService.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDto> getEventById(@PathVariable long id) {
        return ResponseEntity.ok(this.eventService.getEventById(id));
    }
}
