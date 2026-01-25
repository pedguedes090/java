import java.util.Scanner;

public class Session5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        int ma = sc.nextInt();
        int thousands = ma / 1000;
        int hundreds = ma % 1000 / 100;
        int tenths = ma % 100 / 10;
        int dozens = ma % 10;
        int sumOfFirstThreeNumber = thousands + hundreds +  tenths;
        System.out.println("Chu so ki vong = "+  sumOfFirstThreeNumber);
        if(thousands + hundreds +  tenths == dozens) {
            System.out.println("HOP LE");
        }else{
            System.out.println("SAI MA");
        }
        sc.close();
    }
}
