package de.ait.taskapi.repository;

import de.ait.taskapi.model.Priority;
import de.ait.taskapi.model.Task;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
/* делают - bean єти анотации
@Component

@Controller
@RestController
@Repository
@Service
@Configuration
@Bean
 */

@Repository
public  class TaskDB implements TaskRepository{
    private static HashMap<Long, Task> map = new HashMap<>();
    private static Long lastId = 5L;
    static {
        map.put(1L, new Task(1L, "Task 1", Priority.LOW));
        map.put(2L, new Task(2L, "Task 2", Priority.MIDDLE));
        map.put(3L, new Task(3L, "Task 3", Priority.HIGH));
        map.put(4L, new Task(4L, "Task 4", Priority.LOW));
        map.put(5L, new Task(5L, "Task 5", Priority.MIDDLE));
    }

    public List<Task> findAll(){
        return map.values().stream().toList();
    }
    // или значение Task или null
    public Task findById(Long id){
        return map.get(id);

    }
    public Task save(Task task){
        task.setId(++lastId);
        map.put(lastId, task);
        return task;
    }

    public Task deleteById(Long id){
        return map.remove(id);
    }

    private Long getLastId(){
        return lastId;
    }
}
