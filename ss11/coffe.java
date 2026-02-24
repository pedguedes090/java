public class coffe extends Drink{
    boolean hasMilk;

    @Override
    public double caculatePrice() {
        if(hasMilk){
            return super.caculatePrice()+5000;
        }else {
            return super.caculatePrice();
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        if(hasMilk){
            System.out.println("co sua ");
        }else {
            System.out.println("den da");
        }
    }
}
