import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskBoardImpl2 implements TaskBoard{
    private Queue<String> tasks = new LinkedList<>();
    private int MAX_CAPACITY = 5;

    private Lock lock = new ReentrantLock();
    private Condition managerCondition = lock.newCondition();
    private Condition workerCondition = lock.newCondition();
/*
newCondition() — это метод интерфейса Lock в Java, который используется для создания объекта Condition.
Этот объект позволяет управлять потоками, ожидающими выполнения определенного условия, аналогично методам
wait и notify в synchronized блоках. В этом примере один поток может ждать выполнения условия (awaitCondition()),
 а другой — сигнализировать о его выполнении (signalCondition()). Это помогает избежать проблем с конкурентным
 доступом к ресурсам.
 */

    @Override
    public void setTask(String task) {
    lock.lock();
    try {
        while (tasks.size() >= MAX_CAPACITY ){
            managerCondition.await();
        }
        tasks.offer(task);
        workerCondition.signal(); // не notify
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    } finally {
        lock.unlock();
    }
    }

    @Override
    public String getTask() {
        lock.lock();
        try {
            while (tasks.isEmpty()){
                workerCondition.await();
            }
            String result = tasks.poll();
            managerCondition.signal();
            return result;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}



