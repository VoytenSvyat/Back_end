public class Main {
    public static void main(String[] args) throws InterruptedException {
        //3. В последнем примере, написанном на занятие (банковский счет), класс Account является не
        // потокобезопасным, т.е. если вызывать методы этого класса напрямую, минуя метод transfer из
        // разных потоков - мы получим проблемы. Ваша задача, сделать этот класс потокобезлпасным.
        // Подумайте, решит ли проблеиу Atomic.

        Account accountA = new Account("DE1111", "Jack", 1000);
        Account accountB = new Account("DE2222", "John", 1000);

        Thread thread1 = new Thread(() -> transfer(accountA, accountB, 100), "T1");
        Thread thread2 = new Thread(() -> transfer(accountB, accountA, 500), "T2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(accountA);
        System.out.println(accountB);
    }

    public static void transfer(Account from, Account to, double amount) {
        Account first = from.getBalance() < to.getBalance() ? from : to;
        Account second = from.getBalance() < to.getBalance() ? to : from;

        first.getLock().lock();
        try {
            second.getLock().lock();
            try {
                from.withdraw(amount);
                to.deposit(amount);
                System.out.println("Transfer completed by " + Thread.currentThread().getName());
            } finally {
                second.getLock().unlock();
            }
        } finally {
            first.getLock().unlock();
        }
    }
}