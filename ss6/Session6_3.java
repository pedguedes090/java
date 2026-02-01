package Session6;
 class Product{
    private String productId;
    private String productName;
    private int price;

     public Product(String productId, String productName, int price) {
         this.productId = productId;
         this.productName = productName;
         this.price = price;
     }

     public int getPrice() {
         return price;
     }

     public void setPrice(int price) {
         this.price = price;
     }

     public void Display(){
         System.out.println("Price :L "+price);
     }
 }
public class Session6_3 {
public static void main(String[] args) {
Product prd1 = new Product("1","Chuột",100000);
prd1.Display();
prd1.setPrice(99999999);
prd1.Display();
}
 }
