package Session10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Product {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
}

public class Session10_6 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 1500));
        products.add(new Product("Mouse", 25));
        products.add(new Product("Keyboard", 70));
        products.add(new Product("Monitor", 300));

        Collections.sort(products, new Comparator<Product>() {

            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.price, p2.price);
            }
        });

        System.out.println("Sap xep theo gia tang dan:");
        for (Product p : products) {
            System.out.println(p);
        }

        products.sort((p1, p2) -> p1.name.compareTo(p2.name));

        System.out.println("\nSap xep theo ten A-Z:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
