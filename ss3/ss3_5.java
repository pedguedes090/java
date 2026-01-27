import java.util.Scanner;

public class ss3_5 {
    public static int deleteBook(int[] arr, int n, int bookId) {
        int index = -1;
        for(int i = 0; i < n; i++) if(arr[i] == bookId) {
            index = i;
            break;
        }
        if(index == -1) {
            System.out.println("Khong tim thay ma sach " + bookId);
            return n;
        }
        for(int i = index; i < n - 1; i++) arr[i] = arr[i + 1];
        System.out.println("Da xoa sach ma " + bookId);
        return n - 1;
    }
    public static void displayBooks(int[] arr, int n) {
        System.out.print("Kho sach hien tai (" + n + " cuon): [");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] books = {101, 102, 103, 104, 105};
        int n = books.length, bookId = -1;
        displayBooks(books, n);
        while (true) {
            if (bookId == 0 || n == 0) break;
            System.out.print("Nhap ma sach de xoa (0 de thoat): ");
            bookId = sc.nextInt();
            n = deleteBook(books, n, bookId);
            displayBooks(books, n);
        }
        
    }
}
