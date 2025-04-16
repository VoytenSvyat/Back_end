public class Main {
    public static void main(String[] args) throws InterruptedException {
        String name = Thread.currentThread().getName();
        final long id = Thread.currentThread().getId(); // - только один раз можна использовать финальную переменную

        // id =10;
        System.out.println(name + " " + id + " START");

        // создание Thread через анонимний класс, может создаваться внутри кода без имени для одного раза
        Thread thread1 = new Thread() { // Main$01 extends Thread
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +  " START анонимний класс");
            }
        };

        Thread[] threads = {
                new MyThread(),
                new MyThread(),
                new Thread(new MyRunnable()),
                new Thread(()-> { System.out.println(Thread.currentThread().getName() +  " START LAMBDA"); } ), // функциональний интерфейс, используеться с лямбдой виражения
                thread1
        };

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        Thread.sleep(1000);
        System.out.println(name + " " +  id+ " FINISH");
    }
}