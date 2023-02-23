package com.sgtpo.occurrenceservice.endpoint.controller;

import com.sgtpo.occurrenceservice.endpoint.dto.OccurrenceRequest;
import com.sgtpo.occurrenceservice.endpoint.dto.OccurrenceResponse;
import com.sgtpo.occurrenceservice.endpoint.service.OccurrenceService;
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
@RequestMapping("v1/api/occurrence")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OccurrenceController {

    private final OccurrenceService occurrenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOccurrence(@RequestBody OccurrenceRequest occurrenceRequest){
        occurrenceService.createOccurrence(occurrenceRequest);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<OccurrenceResponse> getAllOccurrences() {
        return occurrenceService.getAllOccurrences();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getOccurrenceById(@PathVariable long corId) {
        String occurrence = occurrenceService.getOccurrenceById(corId);
        return ResponseEntity.ok().body(occurrence);
    }

}