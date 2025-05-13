package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerDto;
import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;
    @Override

    public List<ProgrammerDto> getAllProgrammers() {
        return repository.findAll()
                .stream()
                .map(programmer -> {
                    return new ProgrammerDto(programmer.getName());
                })
                .toList();
    }
}
