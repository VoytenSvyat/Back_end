public class Manager implements Runnable {
    private TaskBoard taskBoard;
    private int nTask;

    public Manager(TaskBoard taskBoard, int nTask) {
        this.taskBoard = taskBoard;
        this.nTask = nTask;
    }

    public Manager(TaskBoard taskBoard) {
        this.taskBoard = taskBoard;
    }

    @Override
    public void run() {
        for (int i = 0; i < nTask; i++) {
            int taskNumber = i;
            taskBoard.setTask(()-> System.out.println("Задача " + taskNumber + " виполнена."));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
