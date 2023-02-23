package com.sgtpo.occurrenceservice.endpoint.dto;

import com.sgtpo.core.enums.PublicAgency;
import com.sgtpo.core.enums.OccorrenceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Data
@Builder
@AllArgsConstructor
public class OccurrenceRequest {
    private String interdictionPlace;
    private OccorrenceType occurrenceType;
    private String description;
    private String neighborhood;
    private List<PublicAgency> publicAgenciesInvolved;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
