public class Ex_04 {
    static class Animal {
        public void sound() {
            System.out.println("Động vật phát ra âm thanh");
        }
    }
    static class Dog extends Animal {
        public void sound() {
            System.out.println("Chó sủa: Gâu gâu!");
        }

        public void bite() {
            System.out.println("Chó đang cắn!");
        }
    }
    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.bite();
        }
    }
}
