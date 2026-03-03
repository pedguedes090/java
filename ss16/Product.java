public class Product {
    private String id;
    private String name;
    private Double price;

    public Product(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public double calculateFinalPrice(){
        return price;
    }
    public void displayInfo(){
        System.out.println(id + " " + name + " " + price);
    }

    public String getId() {
        return id;
    }
}
