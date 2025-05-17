package de.ait.taskapi.controller;

import de.ait.taskapi.dto.TaskRequestDto;
import de.ait.taskapi.dto.TaskResponseDto;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.TaskRepository;
import de.ait.taskapi.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;

// @AllArgsConstructor
@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskRepository repository;// repository временно
    private final TaskService service;

    private  Scanner scanner;


    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> getTasks(){
        return ResponseEntity.ok(service.getAllTasks());

       // List<TaskResponseDto> allTasks = service.getAllTasks();
        // HttpHeaders headers = new HttpHeaders(); // заголовки HTTP
       // headers.add("X-Task-Size", String.valueOf(allTasks.size()));
       // headers.add("X-Task-Hello", "hello from server");
        // return new ResponseEntity<>(allTasks,headers, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> findById(@PathVariable("id") Long taskId){
        TaskResponseDto taskById = service.getTaskById(taskId);
        //return (taskById!=null)? ResponseEntity.ok(taskById) : ResponseEntity.notFound().build();

        return ResponseEntity.ofNullable(taskById);

    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto task){
        TaskResponseDto savedTask = service.save(task);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedTask.getId())
                .toUri();
        return ResponseEntity.created(location).body(savedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskResponseDto> deleteTask(@PathVariable(name = "id") Long taskID){
        TaskResponseDto deletedTask = service.deleteTAsk(taskID);
        return ResponseEntity.ofNullable(deletedTask);

    }

}

