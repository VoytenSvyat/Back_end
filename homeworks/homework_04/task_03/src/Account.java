import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    private final String iban;
    private final String owner;
    private double balance;
    private final Lock lock = new ReentrantLock(); // ReentrantLock — это механизм блокировки в Java,
    // который позволяет управлять доступом к общему ресурсу в многопоточной среде.
    // Он является альтернативой synchronized, но предоставляет больше гибкости.

    public Account(String iban, String owner, double balance) {
        this.iban = iban;
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (getBalance() >= amount) {
                balance -= amount;
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }
}