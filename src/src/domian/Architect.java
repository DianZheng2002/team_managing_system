package domian;

public class Architect extends Employee{
    private int stock;

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, int stock) {
        super(id, name, age, salary);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
