

public class FruitJuice extends Drink implements IMixable{
    int discountPercent;

    @Override
    public double caculatePrice() {
        return super.caculatePrice()-(price*discountPercent/100);
    }


    @Override
    public void mix() {
        System.out.println("đang ép trái cây tươi ");
    }
}
