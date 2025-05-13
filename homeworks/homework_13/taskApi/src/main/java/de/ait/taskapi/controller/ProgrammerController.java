package de.ait.taskapi.controller;

import de.ait.taskapi.model.Programmer;
import de.ait.taskapi.model.Task;
import de.ait.taskapi.repository.ProgrammerRepository;
import de.ait.taskapi.repository.ProgrammerRepositoryMapImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProgrammerController {
    private final ProgrammerRepository repository;


    @GetMapping("/programmers")
    public List<Programmer> getProgrammers(){
       return repository.findAll();
    }

    @GetMapping("/programmers/{id}")
    public Programmer getProgrammerById(@PathVariable("id") Long id){
        return repository.findById(id);
    }

    // получить список задач заданного программиста (GET programmers/id/tasks)
    @GetMapping("/programmers/{id}/tasks")
    public List<Task> getTaskByProgrammer(@PathVariable("id") Long id){
        return  repository.findTasksByProgrammerId(id);
    }

    //поручить программисту задачу (PUT programmers/programmerId/tasks/taskId)
    @PutMapping("/programmers/{programmerId}/tasks/{taskId}")
    public void addTakToProgrammer(@PathVariable("programmerId") Long programmerId, @PathVariable("taskId") Long taskId){
        repository.addTaskToProgrammer(programmerId, taskId);
    }


}
