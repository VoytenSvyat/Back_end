import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {
    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);

    public void updateLatency(int latency) {
        int currentMin;
        do {
            currentMin = minLatency.get();
            if (latency >= currentMin) {
                return;
            }
        } while (!minLatency.compareAndSet(currentMin, latency));
    }

    public int getMinLatency() {
        return minLatency.get();
    }
}
