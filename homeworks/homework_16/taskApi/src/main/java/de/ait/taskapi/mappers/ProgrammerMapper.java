package de.ait.taskapi.mappers;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.dto.ProgrammerResponseDto;
import de.ait.taskapi.model.Programmer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProgrammerMapper {
    ProgrammerResponseDto toResponseDto(Programmer task);
    List<ProgrammerResponseDto> toResponseDtoList(List<Programmer> programmers);
    Programmer fromRequestDto(ProgrammerRequestDto dto);
}
