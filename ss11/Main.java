
public class Main {
    public static void main(String[] args) {
        Drink[] drinks = new Drink[3];
        coffe coffee = new coffe();
        coffee.name = "Bạc sỉu";
        coffee.price = 30000;
        coffee.hasMilk = true;
        drinks[0] = coffee;

        FruitJuice fruitJuice = new FruitJuice();
        fruitJuice.name = "Nước cam";
        fruitJuice.price = 40000;
        fruitJuice.discountPercent = 10;
        drinks[1] = fruitJuice;

        drinks[2] = null;

        for (int i = 0; i < drinks.length; i++) {
            if (drinks[i] != null) {
                System.out.println("Đồ uống " + (i + 1));

                drinks[i].displayInfo();

                System.out.println("Thành tiền: " + drinks[i].caculatePrice());

                drinks[i].mix();
            }
        }
    }
}

