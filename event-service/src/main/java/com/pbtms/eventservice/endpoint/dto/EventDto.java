package com.pbtms.eventservice.endpoint.dto;

import com.pbtms.core.enums.EventType;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

    private Long id;
    private String ordinance;
    private int ordinanceNumber;
    private EventType eventType;
    private String neighborhood;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String interdictionPlace;
    private String bypassRoute;


}
