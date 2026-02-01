package Session6;
class Book {
    private String bookId;
    private String bookName;
    private String author;
    private double price;
    public Book(String bookId, String bookName, String author, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
    public void displayInfo() {
        System.out.println("Ma sach: " + bookId);
        System.out.println("Ten sach: " + bookName);
        System.out.println("Tac gia: " + author);
        System.out.println("Gia: " + price);
    }
}
public class Session6_5 {
    public static void main(String[] args) {
        Book b1 = new Book("B001", "Lap trinh Java", "Nguyen Van A", 120000);
        b1.displayInfo();
    }
}
