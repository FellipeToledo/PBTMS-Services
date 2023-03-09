package com.pbtms.core.model;

import com.pbtms.core.enums.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Event implements AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String ordinance;

    @NotNull(message = "The field 'ordinanceNumber' is mandatory")
    @Column(nullable = false)
    private int ordinanceNumber;

    @Column(nullable = false)
    @Enumerated
    private EventType eventType;

    @NotNull(message = "The field 'neighborhood' is mandatory")
    @Column(nullable = false)
    private String neighborhood;

    @NotNull(message = "The field 'description' is mandatory")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "The field 'startDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @NotNull(message = "The field 'endDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @NotNull(message = "The field 'interdictionPlace' is mandatory")
    @Column(nullable = false)
    private String interdictionPlace;

    @NotNull(message = "The field 'bypassRoute' is mandatory")
    @Column(nullable = false)
    private String bypassRoute;

    @Override
    public Long getId() {
        return id;
    }

}
