package de.ait.taskapi.repository;

import de.ait.taskapi.model.Task;

import java.util.HashMap;
import java.util.List;

public  class TaskDB implements TaskRepository{
    private static HashMap<Long, Task> map = new HashMap<>();
    static {
        map.put(1L, new Task(1L, "Вскопать город", "Високий"));
        map.put(2L, new Task(2L, "Посадить дерево", "Низкий"));
        map.put(3L, new Task(3L, "Купить продукти", "Високий"));
        map.put(4L, new Task(4L, "Постирать одежду", "Средний"));
        map.put(5L, new Task(5L, "Приготовить лазанью", "Средний"));
    }

    public List<Task> findAll(){
        return map.values().stream().toList();
    }
    public Task findById(Long id){
        return map.get(id);
    }
    public Task save(Task task){
        map.put(task.getId(), task);
        return task;
    }
    public Task deleteById(Long id){
        return map.remove(id);
    }
}
