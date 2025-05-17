package de.ait.taskapi.mappers;


import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;
import de.ait.taskapi.model.Task;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task fromDto(TaskRequestDto dto);
    TaskResponseDto toDto (Task task);
    List<TaskResponseDto> toDtoList(List<Task> task);
}
