public class Toy {
    private final long id;
    private final String name;
    private int quantity;
    /**Вероятность выпадения*/
    private int frequency;


    public Toy(long id, String name, int quantity, int frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public int getFrequency() { return frequency; }

    public void setFrequency(byte frequency) { this.frequency = frequency; }

    public void addQuantity(){ quantity++; }
    public void addQuantity(int quantity){ this.quantity += quantity; }

    public int reduce(){ return reduce(1); }
    public int reduce(int quantity){
        if (this.quantity - quantity > 0) this.quantity = this.quantity - quantity;
        else this.quantity = 0;
        return this.quantity;
    }
}
