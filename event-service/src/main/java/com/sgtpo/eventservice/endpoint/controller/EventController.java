package com.sgtpo.eventservice.endpoint.controller;

import com.sgtpo.eventservice.endpoint.dto.EventRequest;
import com.sgtpo.eventservice.endpoint.dto.EventResponse;
import com.sgtpo.eventservice.endpoint.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("v1/api/eventservice")
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



}
