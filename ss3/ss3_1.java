import java.util.Scanner;

public class ss3_1 {
    public static int[] addBookToLibraries(int n) {
        Scanner sc = new Scanner(System.in);
        int[] books = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.print("Sach thu " + (i + 1) + ": ");
            books[i] = sc.nextInt();
        }
        return books;
    }
    public static void displayLibraries(int[] books) {
        System.out.println("--- KET QUA ---");
        System.out.print("Danh sach ma sach: ");
        for(int i = 0; i < books.length; i++) {
            System.out.print(books[i]);
            if(i < books.length - 1) System.out.print(", ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sach can quan ly: ");
        int n = sc.nextInt();
        System.out.println("Nhap ma cho " + n  + " cuon sach: ");
        int[] books = addBookToLibraries(n);
        displayLibraries(books);
    }
}