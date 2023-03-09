package com.pbtms.core.model;

import com.pbtms.core.enums.OccurrenceType;
import com.pbtms.core.enums.PublicAgency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author Fellipe Toledo
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Occurrence implements AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull(message = "The field 'corId' is mandatory")
    @Column(nullable = false)
    private String corId;

    @NotNull(message = "The field 'interdictionPlace' is mandatory")
    @Column(nullable = false)
    private String interdictionPlace;

    @NotNull(message = "The field 'occurrenceType' is mandatory")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OccurrenceType occurrenceType;

    @NotNull(message = "The field 'description' is mandatory")
    @Column(nullable = false)
    private String description;

    @NotNull(message = "The field 'neighborhood' is mandatory")
    @Column(nullable = false)
    private String neighborhood;

    @NotNull(message = "The field 'publicAgencyInvolved' is mandatory")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PublicAgency publicAgencyInvolved;

    @NotNull(message = "The field 'startDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime startDateTime;

    @NotNull(message = "The field 'endDateTime' is mandatory")
    @Column(nullable = false)
    private LocalDateTime endDateTime;

    @Override
    public Long getId() {
        return id;
    }
}
