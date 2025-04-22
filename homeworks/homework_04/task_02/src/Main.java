public class Main {
    public static void main(String[] args) throws InterruptedException {
        // 2. Компания разрабатывает систему мониторинга производительности веб-сервисов. Один из важных показателей
        // — минимальная задержка ответа (latency) от сервера. Нужно реализовать компонент LatencyMonitor, который
        // отслеживает самое минимальное время отклика, полученное из множества параллельных потоков, поступающих от
        // разных серверов/кластеров. Задержка - случайное целое число (мс), в диапазоне от 0 до Integer.MAX_VALUE.
        // Каждый из N потоков-серверов генерирует это число и вызывает метод updateLatency(double latency) класса
        // LatencyMonitor. Реализация не должна использовать synchronized или блокировки — только атомарные структуры
        // (Atomic*).
        LatencyMonitor monitor = new LatencyMonitor();
        int numThreads = 5;

        Thread[] threads = new Thread[numThreads];
        for (int i=0; i<numThreads; i++){
            threads[i] = new Thread(()->{
                for (int j =0; j<100; j++) {
                    int latency = (int) (Math.random() * Integer.MAX_VALUE);
                    monitor.updateLatency(latency);
                }
            });
            threads[i].start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Минимальная задержка: " + monitor.getMinLatency() + " мс");
    }
}