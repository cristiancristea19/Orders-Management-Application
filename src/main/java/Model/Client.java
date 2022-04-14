package Model;
public class Client {
    private int id;
    private String name;
    private int year;
    private String address;

    public Client(int id, String name, int year, String address) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.address = address;
    }

    public Client(){

    }
    public Client(String name, int year, String address) {
        this.name = name;
        this.year = year;
        this.address = address;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", address='" + address + '\'' +
                '}';
    }
}
