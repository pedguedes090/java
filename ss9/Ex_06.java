public class Ex_06 {
    static abstract class Shape {
        public abstract double area();
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double area(double r) {
            return Math.PI * r * r;
        }

        @Override
        public double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double area(double w, double h) {
            return w * h;
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    public static void main(String[] args) {

        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(3);
        shapes[1] = new Rectangle(4, 5);

        double totalArea = 0;

        for (Shape s : shapes) {
            double a = s.area();
            System.out.println("Diện tích: " + a);
            totalArea += a;
        }

        System.out.println("Tổng diện tích: " + totalArea);

        Circle c = new Circle(2);
        System.out.println("Overloading Circle: " + c.area(10));

        Rectangle r = new Rectangle(1, 1);
        System.out.println("Overloading Rectangle: " + r.area(6, 7));
    }
}
