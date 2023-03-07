package com.pbtms.eventservice.endpoint.service;

import java.util.List;

import com.pbtms.eventservice.endpoint.dto.EventDto;

/**
 * @author Fellipe Toledo
 */

public interface EventService {

    EventDto createEvent(EventDto event);

    EventDto updateEvent(EventDto event, Long eventId);

    EventDto getEventById(Long eventId);

    List<EventDto> getAllEvents();

    void deleteEvent(Long eventId);

}
