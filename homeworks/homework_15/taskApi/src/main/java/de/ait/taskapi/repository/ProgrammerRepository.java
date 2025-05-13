package de.ait.taskapi.repository;

import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProgrammerRepository {
    List<Programmer> findAll();
    Programmer  findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskFromProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}
