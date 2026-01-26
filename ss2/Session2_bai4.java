package Session2;

import java.util.Scanner;

public class Session2_bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int id = -1;
        do{
            System.out.println("Nhap ma ID sach moi (Phai > 0) : ");
             id = sc.nextInt();
             if(id<=0) {
                 System.out.println("Loi: ID phai la so duong. Moi nhap lai ");
             }else{
                 System.out.printf("Xac nhan: Ma sach %d da duoc ghi nhan \n " , id );
             }
        }while(id<=0);
            System.out.println("Luu ma sach  thanh cong");

    }
}
