
public abstract class Drink implements IMixable{
    String id ;
    String name ;
    int price ;

    public double caculatePrice(){
        return price;
    }
    public void displayInfo(){
        System.out.println(name);
        System.out.println(price);
    }

    public void mix() {
    }
}
