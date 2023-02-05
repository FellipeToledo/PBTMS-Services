package com.sgtpo.event.endpoint.service;

import com.sgtpo.event.model.Event;
import com.sgtpo.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * @author Fellipe Toledo
 */

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventService {
    private final EventRepository eventRepository;
    public Iterable<Event> list(Pageable pageable){
        log.info("Listing all events");
        return eventRepository.findAll(pageable);
    }
}
