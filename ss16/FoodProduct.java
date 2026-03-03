public class FoodProduct extends Product{
    private int discountPercent;

    public FoodProduct(String id, String name, Double price, int discountPercent) {
        super(id, name, price);
        this.discountPercent = discountPercent;
    }

    @Override
    public double calculateFinalPrice() {
        return super.calculateFinalPrice() - (super.calculateFinalPrice() * discountPercent / 100.0);
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println(discountPercent);
    }
}
