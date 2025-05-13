package de.ait.taskapi.controller;

import de.ait.taskapi.dto.TaskDto;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskDB;
import de.ait.taskapi.repository.TaskRepository;
import de.ait.taskapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

// @AllArgsConstructor
@RestController
@AllArgsConstructor
public class TaskController {
    @Qualifier("taskDB")
    private final TaskRepository repository;
    private final TaskService service;

    private  Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }



    @GetMapping("/tasks")
    public List<TaskDto> getTasks(){
        System.out.println("input");
        String s = scanner.nextLine();
        System.out.println(s);
        return service.getAllTasks();
    }

    @GetMapping("tasks/{id}")
    public TaskDto findById(@PathVariable("id") Long taskId){
        return service.getTaskById(taskId);
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task){
        System.out.println(task);
        return repository.save(task);
    }

    @DeleteMapping("/tasks/{id}")
    public Task deleteTask(@PathVariable(name = "id") Long taskID){
        return repository.deleteById(taskID);
    }

}

