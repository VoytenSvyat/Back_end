public class Main {
    private static final int N_BOX = 1000;
    private static final int CAPACITY = 2;


    public static void main(String[] args) throws InterruptedException {

        Warehouse[] warehouses = {
                new Warehouse("#1"),
                new Warehouse("#2")
        };

        Thread[] loaders = {
                new Thread(new Loader("Jack", N_BOX, CAPACITY, warehouses)),
                new Thread(new Loader("John", N_BOX, CAPACITY, warehouses)),
                new Thread(new Loader("Nick", N_BOX, CAPACITY, warehouses)),
        };

        for (Thread thread : loaders){
            thread.start();
            thread.sleep(15);
        }

        for(Thread thread : loaders){
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Winner: " + Loader.getWinner());
        for (Warehouse warehouse : warehouses ) {
            System.out.println(warehouse);
        }

    }
}