package Session4;

public class Session4_bai1 {
    public static void main(String[] args) {
        String title ="   Lap trinh java                    co ban   ";
        String author=" nguyen van a";
        title = title.trim().replaceAll("\\s+", " ");
        author = author.trim().replaceAll("\\s+", " ");
        System.out.println("["+title.trim().toUpperCase() + "] - Tac gia: "+author.trim().toLowerCase());
    }

}
