package Session4;

public class Session4_bai2 {
    public static void main(String[] args) {
        String description = "Sach giao khoa Toan lop 12, ke: A1-102, tinh trang moi ";
        int pos2 = description.trim().indexOf(", ");
        int startIndex = description.indexOf("ke:") + "ke:".length();
        int endIndex = description.indexOf(",", startIndex);
        String name = description.substring(startIndex, endIndex);
        String newDescription = description.replace("ke:", "vi tri luu tru:");
        System.out.println("Vi tri tim thay " + name);
        System.out.println(newDescription);
    }
}
