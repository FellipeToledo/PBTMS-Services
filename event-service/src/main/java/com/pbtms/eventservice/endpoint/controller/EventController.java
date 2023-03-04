package com.pbtms.eventservice.endpoint.controller;

import com.pbtms.eventservice.endpoint.dto.EventRequest;
import com.pbtms.eventservice.endpoint.dto.EventResponse;
import com.pbtms.eventservice.endpoint.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("v1/api/event")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createEvent(@RequestBody EventRequest eventRequest){
        eventService.createEvent(eventRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<EventResponse> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEventById(@PathVariable long id) {
        String event = eventService.getEventById(id);
        return ResponseEntity.ok().body(event);
    }

}
