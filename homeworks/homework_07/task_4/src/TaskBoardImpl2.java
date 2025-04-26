import java.util.LinkedList;

public class TaskBoardImpl2 implements TaskBoard {
    private final LinkedList<Runnable> tasks = new LinkedList<>();
    private final int MAX_CAPACITY;

    public TaskBoardImpl2(int capacity) {
        this.MAX_CAPACITY = capacity;
    }

    @Override
    public synchronized void setTask(Runnable task) {
        while (tasks.size() >= MAX_CAPACITY) {
            try {
                wait(); // Ждем, если очередь заполнена
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        tasks.add(task);
        notifyAll(); // Будим потоки-потребители
    }

    @Override
    public synchronized Runnable getTask() {
        while (tasks.isEmpty()) {
            try {
                wait(); // Ждем, если задач нет
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Runnable task = tasks.removeFirst();
        notifyAll(); // Будим потоки-производители
        return task;
    }
}
