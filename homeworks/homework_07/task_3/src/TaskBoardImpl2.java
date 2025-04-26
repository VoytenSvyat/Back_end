import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard {
    private LinkedList<String> tasks = new LinkedList<>();
    private int MAX_CAPACITY;

    public TaskBoardImpl2(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    @Override
    public synchronized void setTask(String task) {
        while (tasks.size() >= MAX_CAPACITY) {
            try {
                wait(); // Ждем, если очередь заполнена
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        tasks.add(task);
        notifyAll(); // будем воркеров
    }

    @Override
    public synchronized String getTask() {
        while (tasks.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String result = tasks.removeFirst();
        notifyAll();
        return result;

    }
}



