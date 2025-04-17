public class Loader implements Runnable{
    private String name;
    private int nBox; // количество коробок
    private int capacity; // сколько коробок за раз сможет перенести
    private Warehouse warehouse;
    private int done; // сколько коробок он уже перенес

    public Loader(String name, int nBox, int capacity, Warehouse warehouse) {
        this.name = name;
        this.nBox = nBox;
        this.capacity = capacity;
        this.warehouse = warehouse;
    }


    @Override
    public void run() {
        while (done<nBox){
            int value = Math.min(nBox-done, capacity); // обьем переносящих коробок которие остались
            warehouse.addValue(value);
            done+=capacity;
        }
        System.out.println(name + " finish. Get: " + done + " boxes" );
    }
}
