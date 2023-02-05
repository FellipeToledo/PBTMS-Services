package com.sgtpo.core.repository;

import com.sgtpo.core.model.Event;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Fellipe Toledo
 */
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
}
