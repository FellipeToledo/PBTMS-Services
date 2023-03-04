package com.pbtms.core.repository;

import com.pbtms.core.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface OccurrenceRepository extends JpaRepository<Occurrence, Long> {

}
