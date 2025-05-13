package de.ait.taskapi.service;

import de.ait.taskapi.dto.ProgrammerDto;

import java.util.List;

public interface ProgrammerService {
    List<ProgrammerDto> getAllProgrammers();
}
