package com.sgtpo.event.endpoint.dto;

import com.sgtpo.core.enums.EventType;
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
public class EventRequest {

    private String ordinance;
    private int ordinanceNumber;
    private EventType eventType;
    private String neighborhood;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String roads;
}
