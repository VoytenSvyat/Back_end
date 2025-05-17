package de.ait.taskapi.mappers;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.dto.ProgrammerResponseDto;
import de.ait.taskapi.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    Programmer fromDto(ProgrammerRequestDto dto);
    ProgrammerResponseDto toDto (Programmer programmer);
    List<ProgrammerResponseDto> toDtoList (List<Programmer> programmer);
}
