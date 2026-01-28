package Session4;

import java.util.Scanner;

public class Session4_bai4 {
    public static void main(String[] args) {
        String Regex = "^[A-Z]{2}\\d{4}\\d{5}$\n";
        Scanner input = new Scanner(System.in);
        System.out.println("Moi ban nhap ma thu vien: ");
        String nhap = input.nextLine();
        if(nhap.matches(Regex)){
            System.out.println("ma the hop le");
        }else{
            System.out.println("ma khong hop le");
        }
    }
}
