package com.pbtms.core.model;

import com.pbtms.core.enums.EventType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.Objects;

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
public class Event implements AbstractEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String ordinance;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private int ordinanceNumber;

    @Column(nullable = false)
    @Enumerated
    private EventType eventType;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String neighborhood;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @NotNull(message = "The field 'ordinance' is mandatory")
    @Column(nullable = false)
    private String interdictionPlace;

    private String bypassRoute;

    @Override
    public Long getId() {
        return id;
    }

}
