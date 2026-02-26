import java.util.ArrayList;
import java.util.List;

public class Bai2 {
    public static List<String> kiemTra(List<String> danhSach){
        ArrayList<String> danhSachMoi= new ArrayList<>();
        for(String thuoc:danhSach){
            if(!danhSachMoi.contains(thuoc)){
                danhSachMoi.add(thuoc);
            }
        }
        return danhSachMoi;
    }

    public static void main(String[] args) {
        List<String> danhSach=new ArrayList<>();
        danhSach.add("Paracetamol");
        danhSach.add("Ibuprofen");
        danhSach.add("Panadol");
        danhSach.add("Paracetamol");
        danhSach.add("Aspirin");
        danhSach.add("Ibuprofen");

        System.out.println("Input: " + danhSach);
        List<String> danhSachMoi=kiemTra(danhSach);
        System.out.println("Output: "+danhSachMoi);
    }
}
