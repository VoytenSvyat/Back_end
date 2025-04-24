import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Main2 {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(
                () -> {
                lock.lock();
                 try {
                     System.out.println("Thread-1: Захватили ресурс .....");
                     Thread.sleep(2_000);
                 } catch (InterruptedException e) {
                     throw new RuntimeException(e);
                 } finally {
                     lock.unlock();
                     System.out.println("Thread-1: Освободили ресурс .....");
                 }
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    System.out.println("Thread-2: Попитались захватить ресурс .....");
                    // if (lock.tryLock()){ // - единомоментная попитка захвата ресура
                    try {
                        if (lock.tryLock(1, TimeUnit.SECONDS)){
                        try {
                            System.out.println("Thread-2: Захватили ресурс .....");
                        } finally {
                            lock.unlock();
                            System.out.println("Thread-2: Освободили ресурс .....");
                        }

                    } else  {
                        System.out.println("Thread-2: не смог получить ресурс ....");
                    }
                    } catch (InterruptedException e) {
                        System.out.println("Thread-2:");
                    }
                }
        );

        Thread thread3 = new Thread(()->{
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (lock.hasQueuedThread(thread2)){
                thread2.interrupt();
            }
        });

        Scanner scanner = new Scanner(System.in);
        System.out.println("Пользователь 1 начал длинную операцию");
        thread1.start();
        Thread.sleep(100);

        System.out.println("Пользователь 2 питаеться начать операцию");
        thread2.start();
        //thread3.start();

        //System.out.println("Для вихода нажмите Enter....");
        //scanner.nextLine();
        //thread2.interrupt();
    }
}