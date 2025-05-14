package de.ait.taskapi.repository;

import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//@AllArgsConstructor
public class ProgrammerRepositoryMapImpl implements ProgrammerRepository {
    private final TaskRepository taskRepository;
    private static Long lastId = 3L;
    private static Map<Long, Programmer> map = new HashMap<>();

    public ProgrammerRepositoryMapImpl(@Qualifier("taskDB") TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        map.put(1L, new Programmer(1L, "Jack"));
        map.put(2L, new Programmer(2L, "Nick"));
        map.put(3L, new Programmer(3L, "John"));
        addTaskToProgrammer(1L, 1L);
        addTaskToProgrammer(1L, 2L);
        addTaskToProgrammer(2l, 3L);
    }

    @Override
    public List<Programmer> findAll() {
        return map.values().stream().toList();
    }

    @Override
    public Programmer findById(Long id) {
        Programmer programmer = map.get(id);
        if (programmer==null){
            throw new RuntimeException("Programmer not found");
        } else {
            return programmer;
        }
    }

    @Override
    public Programmer save(Programmer programmer) {
        programmer.setId(++lastId);
        map.put(lastId, programmer);
        return programmer;
    }

    @Override
    public void addTaskToProgrammer(Long programmerId, Long taskId) {
        try {
            Task task = taskRepository.findById(taskId);
            Programmer programmer = map.get(programmerId);
            if (programmer!=null){
                programmer.addTask(task);
            } else {
                throw new RuntimeException("Programmer not found");
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteTaskFromProgrammer(Long programmerId, Long taskId) {
        Programmer programmer = findById(programmerId);
        Task  task = taskRepository.findById(taskId);
        programmer.removeTask(task);

    }

    @Override
    public List<Task> findTasksByProgrammerId(Long id) {
        return new ArrayList<>(findById(id).getTasks());
    }
}
