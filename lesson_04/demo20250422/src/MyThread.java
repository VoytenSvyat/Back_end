public class MyThread extends Thread {
    private volatile boolean isFinish = false; // volatile - позволяет обеспечить happens-before,
    // гарантия виполненния действия когда завершиться первое.
    private int counter =0;

    public synchronized boolean isFinish() {
        return isFinish;
    }

    public synchronized void setFinish(boolean finish) {
        isFinish = finish;
    }

    public int getCounter() {
        return counter;
    }

    @Override
    public void run() {
        System.out.println("Thread start");
        while (!isFinish) {
            counter++;
            if (counter%10000==0){
              //  System.out.println(isFinish);
            }

        }
        System.out.println("Thread finish" + counter);
    }
}
