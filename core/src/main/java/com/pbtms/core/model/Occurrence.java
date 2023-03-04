package com.pbtms.core.model;

import com.pbtms.core.enums.PublicAgency;
import com.pbtms.core.enums.OccorrenceType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
    private Long corId;
    private String interdictionPlace;
    @Enumerated
    private OccorrenceType occorrenceType;
    private String description;
    private String neighborhood;
    @Enumerated
    private List<PublicAgency> publicAgenciesInvolved;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occurrence that = (Occurrence) o;
        return corId.equals(that.corId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(corId);
    }

    @Override
    public Long getId() {
        return corId;
    }
}
