package com.pbtms.occurrenceservice.endpoint.service;

import com.pbtms.core.exceptions.ResourceNotFoundException;
import com.pbtms.core.model.Occurrence;
import com.pbtms.core.repository.OccurrenceRepository;
import com.pbtms.occurrenceservice.endpoint.dto.OccurrenceDto;
import com.pbtms.occurrenceservice.endpoint.mapper.OccurrenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class OccurrenceServiceImp implements OccurrenceService {
    private final OccurrenceRepository occurrenceRepository;
    private final OccurrenceMapper occurrenceMapper;

    @Override
    public OccurrenceDto createOccurrence(OccurrenceDto occurrenceDto) {
        Occurrence occurrence = occurrenceMapper.occurrenceDtoToOccurrence(occurrenceDto);
        Occurrence savedOccurrence = occurrenceRepository.save(occurrence);
        return occurrenceMapper.occurrenceToOccurrenceDto(savedOccurrence);
    }

    @Override
    public OccurrenceDto updateOccurrence(OccurrenceDto occurrenceDto, Long occurrenceId) {
        Occurrence occurrence = occurrenceRepository.findById(occurrenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Occurrence", "Id", occurrenceId));
        occurrence.setInterdictionPlace(occurrenceDto.getInterdictionPlace());
        occurrence.setOccurrenceType(occurrenceDto.getOccurrenceType());
        occurrence.setDescription(occurrenceDto.getDescription());
        occurrence.setNeighborhood(occurrenceDto.getNeighborhood());
        occurrence.setPublicAgencyInvolved(occurrenceDto.getPublicAgencyInvolved());
        occurrence.setStartDateTime(occurrenceDto.getStartDateTime());
        occurrence.setEndDateTime(occurrenceDto.getEndDateTime());

        Occurrence updatedOccurrence = occurrenceRepository.save(occurrence);
        return occurrenceMapper.occurrenceToOccurrenceDto(updatedOccurrence);
    }

    @Override
    public OccurrenceDto getOccurrenceById(Long occurrenceId) {
        Occurrence occurrence = occurrenceRepository.findById(occurrenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Occurrence", "Id", occurrenceId));
        return occurrenceMapper.occurrenceToOccurrenceDto(occurrence);
    }

    @Override
    public List<OccurrenceDto> getAllOccurrence() {
        List<Occurrence> occurrences = occurrenceRepository.findAll();
        return occurrenceMapper.toOccurrenceDtoList(occurrences);
    }

    @Override
    public void deleteOccurrence(Long occurrenceId) {
        Occurrence occurrence = occurrenceRepository.findById(occurrenceId)
                .orElseThrow(() -> new ResourceNotFoundException("Occurrence", "Id", occurrenceId));
        occurrenceRepository.delete(occurrence);
    }
}
