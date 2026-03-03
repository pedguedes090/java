

public class Main {
    public static void main(String[] args) {
        ProductRepository repo = new ProductRepository();
        Product p1 = new FoodProduct("F001", "Milk", 25000.0, 10);
        Product p2 = new FoodProduct("F002", "Bread", 15000.0, 15);
        Product p3 = new ElectronicProduct("E001", "Phone", 5000000.0, 24);
        Product p4 = new ElectronicProduct("E002","laptop",9000000.0,12);
        repo.add(p1);
        repo.add(p2);
        repo.add(p3);
        repo.add(p4);

        for (Product p : repo.findAll()) {
            p.displayInfo();
            System.out.println("Thành tiền: " + p.calculateFinalPrice());
        }
        System.out.println("----------------------------");
        repo.findById("E001").displayInfo();

    }
}