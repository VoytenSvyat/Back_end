package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;

    @Override
    public List<ProgrammerRequestDto> getAllProgrammers() {
        return repository.findAll()
                .stream()
                .map(programmer -> {
                    return new ProgrammerRequestDto(programmer.getName());
                })
                .toList();
    }
}
