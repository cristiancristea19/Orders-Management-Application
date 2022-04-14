package Model;

public class Product {
    private int id;
    private String name;
    private int currentStock;

    public Product(){

    }

    public Product(int id, String name, int currentStock) {
        this.id = id;
        this.name = name;
        this.currentStock = currentStock;
    }

    public Product(String name, int currentStock) {
        this.name = name;
        this.currentStock = currentStock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock){
        this.currentStock = currentStock;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentStock=" + currentStock +
                '}';
    }
}
