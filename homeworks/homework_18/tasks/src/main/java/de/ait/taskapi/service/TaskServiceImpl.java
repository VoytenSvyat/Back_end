package de.ait.taskapi.service;

import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;
import de.ait.taskapi.mappers.TaskMapper;
import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.ProgrammerRepository;
import de.ait.taskapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    @Autowired
    private final TaskRepository repository;
    private final TaskMapper mapper;
    private final ProgrammerRepository programmerRepository;


    @Override
    // return или значение TaskResponseDto или null
    public List<TaskResponseDto> getAllTasks() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public TaskResponseDto getTaskById(Long id) {
        return mapper.toDto(repository.findById(id));
    }

    @Override
    public TaskResponseDto save(TaskRequestDto dto) {
        Task task = mapper.fromDto(dto);
        Programmer programmer = programmerRepository.findTasksByProgrammerId(dto.getProgrammerId())..orElseThrow(() -> new RuntimeException("Category not found"));
        task.setProgrammer(programmer);
        Programmer saved = repository.save(task);
        return mapper.toDto(saved)
    }

    @Override
    public TaskResponseDto deleteTAsk(Long id) {
        return mapper.toResponseDto(repository.deleteById(id));
    }
}
