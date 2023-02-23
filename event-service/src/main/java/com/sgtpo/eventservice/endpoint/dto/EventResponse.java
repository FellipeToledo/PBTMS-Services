package com.sgtpo.eventservice.endpoint.dto;

import com.sgtpo.core.enums.EventType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
    private Long id;
    private String ordinance;
    private int ordinanceNumber;
    @Enumerated
    private EventType eventType;
    private String neighborhood;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String interdictionPlace;
    private String bypassRoute;
}
