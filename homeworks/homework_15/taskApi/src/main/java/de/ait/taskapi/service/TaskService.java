package de.ait.taskapi.service;

import de.ait.taskapi.dto.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getAllTasks();
    TaskDto getTaskById(Long id);
    TaskDto addTask(TaskDto dto);
}
