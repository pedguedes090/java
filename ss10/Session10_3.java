package Session10;
abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }
}

interface Swimmable {
    public void swim();
}

interface Flyable {
    public void fly();
}

class Duck extends Animal implements Swimmable, Flyable {
    public Duck(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " dang boi duoi nuoc");
    }

    @Override
    public void fly() {
        System.out.println(name + " dang bay tren troi");
    }
}

class Fish extends Animal implements Swimmable {
    public Fish(String name) {
        super(name);
    }

    public void swim() {
        System.out.println(name + " dang boi duoi nuoc");
    }
}

public class Session10_3 {
    public static void main(String[] args) {

        Duck duck = new Duck("Vit Donald");
        Fish fish = new Fish("Ca Nemo");

        duck.swim();
        duck.fly();

        fish.swim();
    }
}
