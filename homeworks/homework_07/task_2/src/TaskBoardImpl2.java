import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard{
    private BlockingDeque<String> tasks;

    public TaskBoardImpl2(int capacity){
        this.tasks = new LinkedBlockingDeque<>(capacity);
    }

    @Override
    public void setTask(String task) {
        try{
            tasks.put(task); // Блокирует поток, если очередь заполнена
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getTask() {
        try{
            return tasks.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



