import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex_03 {
    public static void main(String[] args) {
        // Tạo danh mục thuốc BHYT
        Map<String, String> danhMucThuoc = new HashMap<>();
        danhMucThuoc.put("T01", "Paracetamol");
        danhMucThuoc.put("T02", "Ibuprofen");
        danhMucThuoc.put("T03", "Amoxicillin");
        danhMucThuoc.put("T04", "Aspirin");
        danhMucThuoc.put("T05", "Vitamin C");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- TRA CỨU THUỐC BHYT ---");
            System.out.print("Nhập mã thuốc (0 để thoát): ");
            String maThuoc = sc.nextLine().toUpperCase();

            // Thoát chương trình
            if (maThuoc.equals("0")) {
                System.out.println("Kết thúc chương trình.");
                break;
            }

            // Tra cứu
            if (danhMucThuoc.containsKey(maThuoc)) {
                System.out.println("Tên thuốc: " + danhMucThuoc.get(maThuoc));
            } else {
                System.out.println("Thuốc không tồn tại.");
            }
        }

        sc.close();
    }
}
