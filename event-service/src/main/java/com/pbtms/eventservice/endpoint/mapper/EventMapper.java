package com.pbtms.eventservice.endpoint.mapper;

import com.pbtms.core.model.Event;
import com.pbtms.eventservice.endpoint.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EventMapper {

    private final ModelMapper modelMapper;

    public EventDto eventToEventDto(Event event) {
        return modelMapper.map(event, EventDto.class);
    }

    public Event eventDtoToEvent(EventDto eventDto) {
        return modelMapper.map(eventDto, Event.class);
    }

    public List<EventDto> toEventDtoList(List<Event> events) {
        return events.stream().map(this::eventToEventDto)
                .collect(Collectors.toList());
    }
}
