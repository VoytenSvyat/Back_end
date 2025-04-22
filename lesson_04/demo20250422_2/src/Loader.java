import java.util.Random;

public class Loader implements Runnable{
    private final String name;
    private final int nBox;
    private final int capacity;
    private final Warehouse [] warehouse;
    private int done = 0; // Счётчик перенесённых коробок
    private static String winner = null;
    private final static Object lock = new Object();

    public Loader(String name, int nBox, int capacity, Warehouse[] warehouse) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }

    public static String getWinner() {
        return winner;
    }


    @Override
    public void run() {
        while (done<nBox){
            int value = Math.min(nBox-done, capacity); // обьем переносящих коробок, которие остались
            int oneValue = value/warehouse.length;
            for (int i = 0; i < warehouse.length; i++) {
                if (i==0){
                    warehouse[0].addValue(oneValue + (value% warehouse.length));
                } else {
                    warehouse[i].addValue(oneValue);
                }
            }
            done += capacity;
        }
        synchronized (lock) {
            if (winner == null){
                winner = name;
            }
        }
        System.out.println(name + " finish. Get: " + done + " boxes" );
    }
}
