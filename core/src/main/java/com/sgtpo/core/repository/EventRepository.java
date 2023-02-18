package com.sgtpo.core.repository;

import com.sgtpo.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Fellipe Toledo
 */
public interface EventRepository extends JpaRepository<Event, Long> {
}
