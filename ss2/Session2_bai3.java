package Session2;
import java.util.Scanner;
public class Session2_bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong sach tra muon: ");
        int book = sc.nextInt();
        int total = 0;
        for(int i = 1; i <= book; i++) {
            System.out.printf("Nhap so ngay tre cua cuon thu %d: \n", i);
            int late =  sc.nextInt();
            total += late*5000;
        }
        System.out.println("===> Tong tien phat:  " + total);
    }
}
