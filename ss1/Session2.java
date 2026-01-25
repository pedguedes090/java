import java.util.Scanner;
public class Session2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số ngày chậm trễ: ");
        int n = sc.nextInt();
        System.out.print("Nhập số lượng sách mượn: ");
        int m = sc.nextInt();
        int fine = n * m * 5000;
        System.out.println("Tiền phạt gốc: " + fine +"VNĐ");
        int fineAfter =  n * m * 5000;
        if(n>7 && m>=3 ){
             fineAfter = fine + (fine/100 * 20);
        }
        if(fineAfter> 50000 ){
            System.out.println("Yêu cầu khoá thẻ: true");
        }else {
            System.out.println("Yêu cầu khoá thẻ: false");
        }

    }
}
