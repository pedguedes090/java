package Session2;
import java.util.Scanner;

public class Session2_bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap tuoi cua ban: ");
        int old = sc.nextInt();

        System.out.print("Nhap so sach dang muon: ");
        int book = sc.nextInt();

        if (old >= 18 && book < 3) {
            System.out.println("Ket qua: Ban DU DIEU KIEN muon sach quy hiem.");
        } else if (old >= 18 && book >= 3) {
            System.out.println("Ket qua: Khong du dieu kien");
            System.out.println("- Ly do: Ban da muon toi da 3 cuon.");
        } else {
            System.out.println("Ket qua: Khong du dieu kien");
            System.out.println("- Ly do: Ban phai du 18 tuoi tro len.");
        }

        sc.close();
    }
}
