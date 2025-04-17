import java.util.Random;

public class Loader implements Runnable{
    private final String name;
    private final int nBox;
    private final int capacity;
    private final Warehouse warehouse1;
    private final Warehouse warehouse2;
    private int done = 0; // Счётчик перенесённых коробок
    private final Random random = new Random();

    public Loader(String name, int nBox, int capacity, Warehouse warehouse1, Warehouse warehouse2) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse1 = warehouse1;
        this.warehouse2 = warehouse2;
    }


    @Override
    public void run() {
        while (done<nBox){
            int value = Math.min(nBox-done, capacity); // обьем переносящих коробок которие остались
            warehouse1.addValue(value / 2);
            warehouse2.addValue(value / 2);
            done+=capacity;
        }
        System.out.println(name + " finish. Get: " + done + " boxes" );
        if (Main.winnerFound.compareAndSet(false, true)) {
            System.out.println(name +  " финиширует первим и получает бонус!!");
        }
    }
}
