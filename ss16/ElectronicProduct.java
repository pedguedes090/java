

public class ElectronicProduct extends Product{
    private int warrantyMonths;

    public ElectronicProduct(String id, String name, Double price, int warrantyMonths) {
        super(id, name, price);
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public double calculateFinalPrice() {
        return warrantyMonths > 12 ? super.calculateFinalPrice() + 1000000 : super.calculateFinalPrice();
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println(warrantyMonths);
    }
}
