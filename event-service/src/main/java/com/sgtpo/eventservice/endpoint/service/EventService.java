package com.sgtpo.eventservice.endpoint.service;


import com.sgtpo.core.model.Event;
import com.sgtpo.core.repository.EventRepository;
import com.sgtpo.eventservice.endpoint.dto.EventRequest;
import com.sgtpo.eventservice.endpoint.dto.EventResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Fellipe Toledo
 */

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventService {
    private final EventRepository eventRepository;

    public void createEvent(EventRequest eventRequest){
        Event event = Event.builder()
                .ordinance(eventRequest.getOrdinance())
                .ordinanceNumber(eventRequest.getOrdinanceNumber())
                .eventType(eventRequest.getEventType())
                .neighborhood(eventRequest.getNeighborhood())
                .bypassRoute(eventRequest.getBypassRoute())
                .description(eventRequest.getDescription())
                .startDateTime(eventRequest.getStartDateTime())
                .endDateTime(eventRequest.getEndDateTime())
                .interdictionPlace(eventRequest.getInterdictionPlace())
                .build();
        eventRepository.save(event);
        log.info("Event {} is saved", event.getId());
    }
    public List<EventResponse> getAllEvents(){
        log.info("Listing all events");
            List<Event> events = eventRepository.findAll();

            return events.stream().map(this::mapToEventResponse).toList();
    }

    private EventResponse mapToEventResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .ordinance(event.getOrdinance())
                .ordinanceNumber(event.getOrdinanceNumber())
                .eventType(event.getEventType())
                .neighborhood(event.getNeighborhood())
                .bypassRoute(event.getBypassRoute())
                .description(event.getDescription())
                .startDateTime(event.getStartDateTime())
                .endDateTime(event.getEndDateTime())
                .interdictionPlace(event.getInterdictionPlace())
                .build();
    }

    public String getEventById(long id) {
        Optional<String> opt = Optional.ofNullable(System.getenv("foo"));
        // FP on squid:S3655
        return opt.orElse(null);
    }
}
