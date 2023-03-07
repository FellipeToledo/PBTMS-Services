package com.pbtms.eventservice.endpoint.service;

import com.pbtms.core.exceptions.ResourceNotFoundException;
import com.pbtms.core.model.Event;
import com.pbtms.core.repository.EventRepository;
import com.pbtms.eventservice.endpoint.dto.EventDto;
import com.pbtms.eventservice.endpoint.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    @Override
    public EventDto createEvent(EventDto eventDto) {
        Event event = eventMapper.eventDtoToEvent(eventDto);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.eventToEventDto(savedEvent);
    }

    @Override
    public EventDto updateEvent(EventDto eventDto, Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
        event.setOrdinance(eventDto.getOrdinance());
        event.setOrdinanceNumber(eventDto.getOrdinanceNumber());
        event.setEventType(eventDto.getEventType());
        event.setNeighborhood(eventDto.getNeighborhood());
        event.setDescription(eventDto.getDescription());
        event.setStartDateTime(eventDto.getStartDateTime());
        event.setEndDateTime(eventDto.getEndDateTime());
        event.setInterdictionPlace(eventDto.getInterdictionPlace());
        event.setBypassRoute(eventDto.getBypassRoute());

        Event updatedEvent = eventRepository.save(event);
        return eventMapper.eventToEventDto(updatedEvent);
    }

    @Override
    public EventDto getEventById(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
        return eventMapper.eventToEventDto(event);
    }

    @Override
    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return eventMapper.toEventDtoList(events);
    }

    @Override
    public void deleteEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event", "Id", eventId));
        eventRepository.delete(event);
    }
}
