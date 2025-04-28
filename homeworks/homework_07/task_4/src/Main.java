public class Main {
    private final static int N_TASKS=20;
    private final static int N_WORKERS= 5;
    private static int QUEUE_CAPACITY = 5;

    public static void main(String[] args) throws InterruptedException {
        TaskBoard taskBoard = new TaskBoardImpl2(QUEUE_CAPACITY);

        Thread manager = new Thread(new Manager(taskBoard, N_TASKS));

        Thread[] threads = new Thread[N_WORKERS];
        for (int i = 0; i < threads.length; i++) {
            threads[i] =new Thread(new Worker(taskBoard, "jack- " + i));
            threads[i].setDaemon(true);
            threads[i].start();
        }

        taskBoard.setTask(()-> System.out.println("hello from main"));
        taskBoard.setTask(()-> {
            System.out.println("список потоков: ");
            for (int i = 0; i<threads.length; i++){
                System.out.println(threads[i].getName());
            }
        });

        manager.start();
        Thread.sleep(1000);
        manager.join();

    }
}