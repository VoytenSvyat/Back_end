package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerRequestDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerRequestDto> getAllProgrammers();
}
