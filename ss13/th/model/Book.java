package th.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int categoryId;

    public Book(String title, int id, int categoryId, String author) {
        this.title = title;
        this.id = id;
        this.categoryId = categoryId;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void displayData(){
       // System.out.printf(" id: %d | title: %s | author: %s" );
    }
}
