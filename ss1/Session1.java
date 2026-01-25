import  java.util.Scanner;
public class Session1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập mã sách : ");
        String bookId = input.nextLine();
        System.out.print("Nhập tên sách : ");
        String bookName = input.nextLine();
        System.out.print("Nhập năm xuất bản : ");
        int publishYear = input.nextInt();
        System.out.print("Nhập giá bìa : ");
        double price = input.nextDouble();
        System.out.print("Sách còn trong kho (true/false): ");
        Boolean bookStatus = input.nextBoolean();
        System.out.println("--PHIẾU THÔNG TIN SÁCH ");
        System.out.println("Tên sách: " + bookName.toUpperCase() );
        System.out.println("Mã Số: " + bookId +"| Tuổi thọ: " + (2026 - publishYear ) + " nam");
        System.out.println("Giá bán: " + price + " VNĐ");
        Boolean isAvailable = bookStatus.booleanValue();
        if(isAvailable) {
            System.out.println("Tình trạng: Còn sách" );
        }else{
            System.out.println("Tình trạng: Đã mượn" );
        }
        input.close();
    }
}
