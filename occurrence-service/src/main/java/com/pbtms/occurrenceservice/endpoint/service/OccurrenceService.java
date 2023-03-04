package com.pbtms.occurrenceservice.endpoint.service;

import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceRequest;
import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceResponse;
import com.pbtms.core.model.Occurrence;
import com.pbtms.core.repository.OccurrenceRepository;
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
@RequiredArgsConstructor
@Slf4j
public class OccurrenceService {
    @Autowired
    private final OccurrenceRepository occurrenceRepository;

    public void createOccurrence(OccurrenceRequest occurrenceRequest){
        Occurrence occurrence = Occurrence.builder()
                .interdictionPlace(occurrenceRequest.getInterdictionPlace())
                .occorrenceType(occurrenceRequest.getOccurrenceType())
                .description(occurrenceRequest.getDescription())
                .neighborhood(occurrenceRequest.getNeighborhood())
                .publicAgenciesInvolved(occurrenceRequest.getPublicAgenciesInvolved())
                .startDateTime(occurrenceRequest.getStartDateTime())
                .endDateTime(occurrenceRequest.getEndDateTime())
                .build();
        occurrenceRepository.save(occurrence);
        log.info("Occurrence {} is saved", occurrence.getCorId());
    }
    public List<OccurrenceResponse> getAllOccurrences(){
        log.info("Listing all occurrences");
        List<Occurrence> occurrences = occurrenceRepository.findAll();

        return occurrences.stream().map(this::mapToOccurrenceResponse).toList();
    }

    private OccurrenceResponse mapToOccurrenceResponse(Occurrence occurrence) {
        return OccurrenceResponse.builder()
                .corId(occurrence.getCorId())
                .interdictionPlace(occurrence.getInterdictionPlace())
                .occurrenceType(occurrence.getOccorrenceType())
                .description(occurrence.getDescription())
                .neighborhood(occurrence.getNeighborhood())
                .publicAgenciesInvolved(occurrence.getPublicAgenciesInvolved())
                .startDateTime(occurrence.getStartDateTime())
                .endDateTime(occurrence.getEndDateTime())
                .build();
    }

    public String getOccurrenceById(long corId) {
        Optional<String> occurrenceCorId = Optional.ofNullable(System.getenv("occurrenceCorId"));
        return occurrenceCorId.orElse(null);
    }
}
