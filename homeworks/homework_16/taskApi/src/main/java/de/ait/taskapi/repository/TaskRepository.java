package de.ait.taskapi.repository;

import de.ait.taskapi.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Task> findAll();
    public Task findById(Long id);
    public Task save(Task task);
    public Task deleteById(Long id);
}
