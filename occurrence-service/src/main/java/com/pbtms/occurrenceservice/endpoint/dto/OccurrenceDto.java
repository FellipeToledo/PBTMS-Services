package com.pbtms.occurrenceservice.endpoint.dto;

import com.pbtms.core.enums.PublicAgency;
import com.pbtms.core.enums.OccurrenceType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Fellipe Toledo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OccurrenceDto {
    private Long Id;
    private String corId;
    private String interdictionPlace;
    @Enumerated(EnumType.STRING)
    private OccurrenceType occurrenceType;
    private String description;
    private String neighborhood;
    @Enumerated(EnumType.STRING)
    private PublicAgency publicAgencyInvolved;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
}
