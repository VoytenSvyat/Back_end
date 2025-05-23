package de.ait.taskapi.controller;

import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskDB;
import de.ait.taskapi.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Scanner;

// @AllArgsConstructor
@RestController

public class TaskController {

    private final TaskRepository repository;

    private  Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public TaskController(@Qualifier("taskDB") TaskRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        System.out.println("input");
        String s = scanner.nextLine();
        System.out.println(s);
        return repository.findAll();
    }

    @GetMapping("tasks/{id}")
    public Task findById(@PathVariable("id") Long taskID){
        return repository.findById(taskID);
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

