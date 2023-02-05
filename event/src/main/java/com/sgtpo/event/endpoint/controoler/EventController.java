package com.sgtpo.event.endpoint.controoler;

import com.sgtpo.core.model.Event;
import com.sgtpo.event.endpoint.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Fellipe Toledo
 */
@RestController
@RequestMapping("v1/api/event")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {
    private final EventService eventService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Iterable<Event>> list(Pageable pageable) {
        return new ResponseEntity<>(eventService.list(pageable), HttpStatus.OK);
    }
}
