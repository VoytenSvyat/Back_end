package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.dto.ProgrammerResponseDto;
import de.ait.taskapi.mappers.ProgrammerMapper;
import de.ait.taskapi.repository.ProgrammerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProgrammerServiceImpl implements ProgrammerService{
    private final ProgrammerRepository repository;
    private final ProgrammerMapper mapper;

    @Override
    public List<ProgrammerResponseDto> getAllProgrammers() {
        return mapper.toResponseDtoList(repository.findAll());

    }

    @Override
    public ProgrammerResponseDto getProgrammerById(Long Id) {
        return null;
    }

    @Override
    public ProgrammerResponseDto createProgrammer(ProgrammerRequestDto programmerRequestDto) {
        return null;
    }

    @Override
    public ProgrammerResponseDto deleteProgrammer(Long id) {
        return null;
    }
}
