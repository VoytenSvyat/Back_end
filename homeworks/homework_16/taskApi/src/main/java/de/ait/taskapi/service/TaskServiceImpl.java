package de.ait.taskapi.service;

import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;
import de.ait.taskapi.mappers.TaskMapper;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;
    private final TaskMapper mapper;


    /*@Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> taskList = repository.findAll();
        return taskList.stream()
                .map(TaskServiceImpl::getTaskResponseDto)
                .toList();
    }*/

   /* @Override
    public List<TaskResponseDto> getAllTasks() {
        List<Task> taskList = repository.findAll();
        return taskList.stream()
                .map(task -> mapper.toResponseDto(task))
                .toList();
    }
    */

    @Override
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toResponseDtoList(repository.findAll());
    }

    private static TaskResponseDto getTaskResponseDto(Task task) {
        return new TaskResponseDto(task.getId(), task.getDescription(), task.getPriority());
    }

}
