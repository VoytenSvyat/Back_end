package de.ait.taskapi.service;

import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasks();
    TaskResponseDto getTaskById(Long id);
    TaskResponseDto save (TaskRequestDto dto);
    TaskResponseDto deleteTAsk(Long id);
}
