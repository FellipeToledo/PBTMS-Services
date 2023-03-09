package com.pbtms.occurrenceservice.endpoint.controller;

import com.pbtms.core.response.ApiResponse;
import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceDto;
import com.pbtms.occurrenceservice.endpoint.service.OccurrenceService;
import jakarta.validation.Valid;
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
@RequestMapping("api/v1/occurrence")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OccurrenceController {

    private final OccurrenceService occurrenceService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OccurrenceDto> createOccurrence(@Valid @RequestBody OccurrenceDto occurrenceDto) {
        OccurrenceDto createOccurrenceDto = occurrenceService.createOccurrence(occurrenceDto);
        return new ResponseEntity<>(createOccurrenceDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OccurrenceDto> updateOccurrence(@Valid @RequestBody OccurrenceDto occurrenceDto, @PathVariable("id") long id) {
        OccurrenceDto updatedOccurrence = this.occurrenceService.updateOccurrence(occurrenceDto, id);
        return ResponseEntity.ok(updatedOccurrence);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteOccurrence(@PathVariable("id") long id) {
        this.occurrenceService.deleteOccurrence(id);
        return new ResponseEntity<>(new ApiResponse("Occurrence deleted Successfully", true), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<OccurrenceDto>> getAllOccurrences() {
        return ResponseEntity.ok(this.occurrenceService.getAllOccurrence());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OccurrenceDto> getOccurrenceById(@PathVariable long id) {
        return ResponseEntity.ok(this.occurrenceService.getOccurrenceById(id));
    }
}