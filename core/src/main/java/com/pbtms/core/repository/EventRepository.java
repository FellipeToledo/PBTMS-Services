package com.pbtms.core.repository;

import com.pbtms.core.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Fellipe Toledo
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
