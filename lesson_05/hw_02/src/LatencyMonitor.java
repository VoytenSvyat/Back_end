import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LatencyMonitor {
    private final AtomicInteger minLatency = new AtomicInteger(Integer.MAX_VALUE);
    // private final List<String> list = new ArrayList<>(List.of("qwer")); final - содержит только ссилку на обьект,
    // значение обьекта может изменяться.
                                    //5
    public void updateLatency(int latency){
        while (true) {
            int currentMin = minLatency.get(); // - текущее минимальное значение //7

            if (latency >= currentMin) { // - проверка для обновления
                return;
            }                                                       //......7
            if (minLatency.compareAndSet(currentMin, latency)) { // атомарная операция, используемая в многопоточных
                                                            // приложениях для безопасного обновления значения переменной
                return;
            }
        }
    }
    public void updateLatency2(int latency){
        minLatency.updateAndGet(current->Math.min(current, latency));
    }

    public int getMinLatency(){
        return minLatency.get();
    }
}
