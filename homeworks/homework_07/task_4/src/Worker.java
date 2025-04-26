public class Worker implements Runnable{
    private TaskBoard taskBoard;
    private String name;

    public Worker(TaskBoard taskBoard, String name) {
        this.taskBoard = taskBoard;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            Runnable task = taskBoard.getTask();
            System.out.println("Испоняет " + name);
            task.run();
        }
    }
}
