import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_02 {
    public static void main(String[] args) {
        // Tạo HashMap lưu danh mục thuốc BHYT
        Map<String, String> danhMucThuoc = new HashMap<>();

        // Thêm sẵn 5 loại thuốc
        danhMucThuoc.put("T01", "Paracetamol");
        danhMucThuoc.put("T02", "Ibuprofen");
        danhMucThuoc.put("T03", "Amoxicillin");
        danhMucThuoc.put("T04", "Aspirin");
        danhMucThuoc.put("T05", "Vitamin C");

        // Nhập mã thuốc cần tra cứu
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã thuốc: ");
        String maThuoc = sc.nextLine().toUpperCase();

        // Tra cứu
        if (danhMucThuoc.containsKey(maThuoc)) {
            System.out.println("Tên thuốc: " + danhMucThuoc.get(maThuoc));
        } else {
            System.out.println("Thuốc không có trong danh mục BHYT");
        }

        sc.close();
    }
}
