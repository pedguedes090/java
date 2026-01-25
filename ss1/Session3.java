import java.util.Scanner;
public class Session3 {
    public static void main(String[] args) {
        String book1 = "Java Basic";
        String book2 = "Python Intro";
        String temp;
        System.out.println("Trước khi thay đổi: Book1 = " + book1 + ", Book2 =  " + book2);
        temp = book1;
        //gán temp thành giá trị của book1
        book1 = book2;
        // đổi book1 thành book2
        book2 = temp;
        //đổi book2 thành book 1
        System.out.println("Trước khi thay đổi: Book1 = " + book1 + ", Book2 =  " + book2);
    }
}
