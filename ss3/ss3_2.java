import java.util.Scanner;

public class ss3_2 {
    public static int searchBook(String[] title, String search) {
        for(int i = 0; i < title.length; i++) if (title[i].equalsIgnoreCase(search)) return i;
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] books = {"Doraemon", "Conan", "One Piece", "Dragon Ball"};
        System.out.print("Nhap ten sach can tim: ");
        String search = sc.nextLine();
        int index = searchBook(books, search);
        if(index != -1) System.out.println("Tim thay sach " + search + " tai vi tri so: " + index);
        else System.out.println("Sach khong ton tai trong thu vien.");
    }
}
