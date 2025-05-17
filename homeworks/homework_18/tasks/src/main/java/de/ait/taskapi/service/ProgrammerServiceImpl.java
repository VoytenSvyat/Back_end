package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.dto.ProgrammerResponseDto;
import de.ait.taskapi.mappers.ProgrammerMapper;
import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.repository.ProgrammerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return mapper.toDtoList(repository.findAll());

    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long Id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }

    @Override
    public ProgrammerResponseDto save(ProgrammerRequestDto dto) {
        Programmer programmer = mapper.fromDto(dto);
        Programmer saved = repository.save(programmer);
        return mapper.toDto(saved);
    }

    @Override
    public ProgrammerResponseDto deleteProgrammer(Long id) {
        return null;
    }
}
