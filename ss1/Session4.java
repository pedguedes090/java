import java.util.Scanner;
public class Session4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap gia sach (USD - kieu double): ");
        double price = sc.nextDouble();
        price = (price * 26269.54);
        System.out.println("Gia chinh xac (so thuc): "+ price);
        System.out.println("Gia lam tron de thanh toan: "+ (long)(price));
        sc.close();
    }
}
