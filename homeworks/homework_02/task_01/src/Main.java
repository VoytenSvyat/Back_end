public class Main {
    public static void main(String[] args) throws InterruptedException{

        Thread thread1 = new Thread(()-> {
            int number = 1;
            while (!Thread.currentThread().isInterrupted()) {
                if (number % 2 == 0) {
                    System.out.println("Число, делящееся на 2: " + number);
                }
                number++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int number = 1;
            while (!Thread.currentThread().isInterrupted()) {
                if (number % 3 == 0) {
                    System.out.println("Число, делящееся на 3: " + number);
                }
                number++;
                try {
                    Thread.sleep(100); // Пауза, чтобы вывод был более наглядным
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(3000);

        thread1.interrupt();
        thread2.interrupt();

        System.out.println("Програма завершена");
    }
}