package com.sgtpo.event.repository;

import com.sgtpo.event.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Fellipe Toledo
 */
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
