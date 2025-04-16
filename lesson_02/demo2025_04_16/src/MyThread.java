public class MyThread extends Thread {

    @Override
    public void run() {
        // в каждого треда есть свое системное имя и id, силку на текущий тред
        String name = Thread.currentThread().getName(); // текущий поток - Thread.currentThread()
        System.out.println("Thread " + name + " start");

        for (int i = 0; i < 10; i++) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(500); // пауза 1 секуда = 1000 милисекунд
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Thread " + name + " finish");
    }
}
