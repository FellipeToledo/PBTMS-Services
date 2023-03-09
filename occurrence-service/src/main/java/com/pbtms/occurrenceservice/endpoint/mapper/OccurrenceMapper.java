package com.pbtms.occurrenceservice.endpoint.mapper;

import com.pbtms.core.model.Occurrence;
import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OccurrenceMapper {

    private final ModelMapper modelMapper;

    public OccurrenceDto occurrenceToOccurrenceDto(Occurrence occurrence) {
        return modelMapper.map(occurrence, OccurrenceDto.class);
    }

    public Occurrence occurrenceDtoToOccurrence(OccurrenceDto occurrenceDto) {
        return modelMapper.map(occurrenceDto, Occurrence.class);
    }

    public List<OccurrenceDto> toOccurrenceDtoList(List<Occurrence> occurrences) {
        return occurrences.stream().map(this::occurrenceToOccurrenceDto)
                .collect(Collectors.toList());
    }
}
