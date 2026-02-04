public class Ex_02 {
    static class Animal {
        public void sound() {
            System.out.println("Động vật phát ra âm thanh");
        }
    }
    static class Dog extends Animal {
        @Override
        public void sound() {
            System.out.println("Chó sủa: Gâu gâu!");
        }
    }
    static class Cat extends Animal {
        @Override
        public void sound() {
            System.out.println("Mèo kêu: Meo meo!");
        }
    }
    public static void main(String[] args) {

        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
