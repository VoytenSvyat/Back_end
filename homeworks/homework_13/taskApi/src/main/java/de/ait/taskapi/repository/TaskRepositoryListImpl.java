package de.ait.taskapi.repository;

import de.ait.taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TaskRepositoryListImpl implements TaskRepository {
    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public Task deleteById(Long id) {
        return null;
    }
}
