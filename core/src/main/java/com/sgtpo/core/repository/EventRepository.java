package com.sgtpo.core.repository;

import com.sgtpo.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
