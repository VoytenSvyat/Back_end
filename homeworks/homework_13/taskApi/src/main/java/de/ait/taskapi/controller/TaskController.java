package de.ait.taskapi.controller;

import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskDB;
import de.ait.taskapi.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    TaskRepository repository = new TaskDB();

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return repository.findAll();
    }

    @GetMapping("tasks/{id}")
    public Task findById(@PathVariable(name= "id") Long taskID){
        return repository.findById(taskID);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable(name = "id") Long taskID){
        return repository.deleteById(taskID);
    }

}

