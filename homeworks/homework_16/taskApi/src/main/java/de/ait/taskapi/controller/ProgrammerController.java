package de.ait.taskapi.controller;

import de.ait.taskapi.dto.ProgrammerRequestDto;
import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.ProgrammerRepository;
import de.ait.taskapi.service.ProgrammerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProgrammerController {
    private final ProgrammerRepository repository;
    private final ProgrammerService service;


    @GetMapping("/programmers")
    public ResponseEntity<List<ProgrammerRequestDto>> getProgrammers(){
        List<ProgrammerRequestDto> allProgrammers = service.getAllProgrammers();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Programmer-Size", String.valueOf(allProgrammers.size()));
       return new ResponseEntity<>(allProgrammers, headers, HttpStatus.OK);
    }

    @GetMapping("/programmers/{id}")
    public ResponseEntity<Programmer> getProgrammerById(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(repository.findById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    // получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public ResponseEntity<List<Task>> getTaskByProgrammer(@PathVariable("id") Long id){
        List<Task> taskList = repository.findTasksByProgrammerId(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Programmer-Task-Size", String.valueOf(taskList.size()));
        return  new ResponseEntity<>(taskList, headers, HttpStatus.OK);
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTakToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId){
        repository.addTaskToProgrammer(programmerId, taskId);
    }


}
