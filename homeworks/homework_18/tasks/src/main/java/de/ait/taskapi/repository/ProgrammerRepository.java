package de.ait.taskapi.repository;

import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProgrammerRepository extends JpaRepository<Programmer, Long> {
    List<Programmer> findAll();
    Optional<Programmer> findById(Long id);
    Programmer save(Programmer programmer);

    void addTaskToProgrammer(Long programmerId, Long taskId);
    void deleteTaskFromProgrammer(Long programmerId, Long taskId);
    List<Task> findTasksByProgrammerId(Long id);

}
