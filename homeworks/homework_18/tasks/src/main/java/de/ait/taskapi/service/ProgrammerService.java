package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.dto.ProgrammerResponseDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerResponseDto> getAllProgrammers();
    ProgrammerResponseDto getProgrammerById(Long Id);

    ProgrammerResponseDto save(ProgrammerRequestDto dto);

    ProgrammerResponseDto deleteProgrammer(Long id);

}
