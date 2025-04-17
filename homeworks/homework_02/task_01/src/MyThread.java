public class MyThread extends  Thread {

    public void run() {
        while (!isInterrupted()) {
            System.out.println("Поток работает..." + isInterrupted());
            Thread.yield();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                //System.out.println("Поток прерван во время сна");
                break;
            }
        }
        System.out.println("Поток завершен");
    }
}
