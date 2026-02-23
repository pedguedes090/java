package Session10;

abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public abstract void move();
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang dong co");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String brand) {
        super(brand);
    }

    @Override
    public void move() {
        System.out.println(brand + " - Cach di chuyen: Di chuyen bang suc nguoi");
    }
}

public class Session10_2 {
    public static void main(String[] args) {

        Vehicle car = new Car("Toyota");
        Vehicle bike = new Bicycle("Giant");

        car.move();
        bike.move();
    }
}