import java.util.*;

public class Ex_01 {
    public static void main(String[] args) {
        // LinkedHashSet: không trùng + giữ thứ tự thêm vào
        Set<String> danhSachBenhNhan = new LinkedHashSet<>();

        // Input mẫu
        danhSachBenhNhan.add("Nguyễn Văn A – Yên Bái");
        danhSachBenhNhan.add("Trần Thị B – Thái Bình");
        danhSachBenhNhan.add("Nguyễn Văn A – Yên Bái"); // trùng -> tự bỏ
        danhSachBenhNhan.add("Lê Văn C – Hưng Yên");

        // In danh sách gọi khám
        System.out.println("Danh sách gọi khám:");
        for (String benhNhan : danhSachBenhNhan) {
            System.out.println(benhNhan);
        }
    }
}
