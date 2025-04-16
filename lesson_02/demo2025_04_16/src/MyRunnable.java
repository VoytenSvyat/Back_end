public class MyRunnable  implements Runnable {
    // "второй" вариант создания потока Thread
    // 1. реализуем Runnable
    // 2. создаем new Thread(runnable)
    @Override
    public void run() {
        String name = Thread.currentThread().getName(); // текущий поток - Thread.currentThread()
        System.out.println("(i) Thread " + name + " start");

        for (int i = 0; i < 10; i++) {
            System.out.println("(i) " + name + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("(i) Thread " + name + " finish");
    }
}
