package Session2;

import java.util.Scanner;

public class Session2_bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Reputation = 100;
        int choice = 0;
        int delPoint = 0;
        int addPoint = 0;
        while(choice != 999){
            System.out.println("Moi ban nhap ngay tra sach muon: ");
            choice = sc.nextInt();
            if(choice > 0){
                delPoint = -choice*2;
                System.out.printf("-> Tra tre %d ngay : %d diem\n ",choice,delPoint);
                Reputation += delPoint;
            } else if (choice < 0) {
                addPoint = -choice*5;
                System.out.printf("-> Tra truoc %d ngay : %d diem\n ",choice,addPoint);
                Reputation -= addPoint;
            }else{
                System.out.println("Tra dung han");
            }
        }
        if(Reputation > 120){
            System.out.println("Doc gia than thiet");
        }else if(Reputation > 80 && Reputation < 120){
            System.out.println("Doc gia tieu chuan");
        }else{
            System.out.println("Doc gia can luu y");
        }

    }
}
