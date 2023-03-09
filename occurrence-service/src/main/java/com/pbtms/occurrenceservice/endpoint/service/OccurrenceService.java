package com.pbtms.occurrenceservice.endpoint.service;

import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceDto;

import java.util.List;

/**
 * @author Fellipe Toledo
 */
public interface OccurrenceService {

    OccurrenceDto createOccurrence(OccurrenceDto occurrence);

    OccurrenceDto updateOccurrence(OccurrenceDto occurrence, Long occurrenceId);

    OccurrenceDto getOccurrenceById(Long occurrenceId);

    List<OccurrenceDto> getAllOccurrence();

    void deleteOccurrence(Long occurrenceId);


}
