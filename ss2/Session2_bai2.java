package Session2;
import java.util.Scanner;
public class Session2_bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma khu vuc(A B C D): ");
        String a = sc.nextLine();
        switch (a){
            case "A":
                System.out.println("Vi tri: Tang 1 - Sach Van Hoc ");
            break;
            case "B":
                System.out.println("Vi tri: Tang 2 - Sach Khoa hoc ");
                break;
            case "C":
                System.out.println("Vi tri: Tang 3 - Sach Ngoai ngu ");
                break;
            case "D":
                System.out.println("Vi tri: Tang 4 - Sach Tin hoc ");
                break;
            default:
                System.out.println("Loi: Ma khu vuc khong hop le!");
                break;
        }
    }
}
