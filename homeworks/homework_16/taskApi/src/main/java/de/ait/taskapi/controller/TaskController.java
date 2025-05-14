package de.ait.taskapi.controller;

import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskRepository;
import de.ait.taskapi.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

// @AllArgsConstructor
@RestController
public class TaskController {
    @Qualifier("taskDB")
    private final TaskRepository repository;// repository временно
    private final TaskService service;

    private  Scanner scanner;

    @Autowired
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
    public TaskController(@Qualifier("taskDB") TaskRepository repository, TaskService service){
        this.repository = repository;
        this.service = service;
    }
    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> getTasks(){
        // return ResponseEntity.ok(service.getAllTasks());

        List<TaskResponseDto> allTasks = service.getAllTasks();
        HttpHeaders headers = new HttpHeaders(); // заголовки HTTP
        headers.add("X-Task-Size", String.valueOf(allTasks.size()));
        headers.add("X-Task-Hello", "hello from server");
        return new ResponseEntity<>(allTasks,headers, HttpStatus.OK);

    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<Task> findById(@PathVariable("id") Long taskId){
        try {
            return ResponseEntity.ok(repository.findById(taskId));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/tasks")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task saved = repository.save(task);
        try {
            return ResponseEntity.created(new URI("http://localhost:8081/tasks/"+saved.getId())).body(saved);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable(name = "id") Long taskID){
        try {
            return ResponseEntity.ok(repository.deleteById(taskID));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }

}

