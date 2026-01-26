package Session2;

import java.util.Scanner;

public class Session2_bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap luot muon ngay Thu 2: ");
        int choice = sc.nextInt();
        int max = choice;
        int min = choice;
        int total = choice;
        for (int i = 3; i <= 8; i++) {
            String dayName;
            if (i == 8) {
                dayName = "Chu nhat";
            } else {
                dayName = "Thu " + i;
            }
            System.out.print("Nhap luot muon ngay " + dayName + ": ");
            choice = sc.nextInt();
            if (choice > max) max = choice;
            if (choice < min) min = choice;
            total += choice;
        }
        double avg = total / 7.0;
        System.out.println("\n--KET QUA THONG KE--");
        System.out.println("Luot muon cao nhat: " + max);
        System.out.println("Luot muon thap nhat: " + min);
        System.out.println("Trung binh luot muon/ngay: " + avg);
        sc.close();

    }
}
