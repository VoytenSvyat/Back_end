package de.ait.taskapi.service;

import de.ait.taskapi.dto.TaskDto;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Qualifier("taskDB")
    private final TaskRepository repository;

    @Override
    public List<TaskDto> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(task -> {
                    return new TaskDto(task.getDescription(), task.getPriority());
                })
                .toList();
    }
    private static TaskDto toTaskDto(Task task){
        return new TaskDto(task.getDescription(), task.getPriority());
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = repository.findById(id);
        if (task!=null){
            return toTaskDto(task);
        } else {
            throw new RuntimeException("Task not found");
        }
    }

    @Override
    public TaskDto addTask(TaskDto dto) {
        return null;

    }
}
