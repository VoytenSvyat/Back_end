import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Warehouse {
    private String title;
    private AtomicInteger value = new AtomicInteger(); // при атомике не нужна дополнительная синхронизация, если только одно значение, то тогда применяем atomic
    private Object lock = new Object();

    public Warehouse(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }

    public void addValue(int value){
        { // this - блокировка монитора
            this.value.getAndAdd(value);
            //this.value += value;
        }
    }
}
