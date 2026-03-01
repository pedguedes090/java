import java.util.*;

public class Ex_04 {
    public static void main(String[] args) {
        // Danh sách ca bệnh trong ngày
        List<String> danhSachBenh = Arrays.asList(
                "Cúm A",
                "Sốt xuất huyết",
                "Cúm A",
                "Covid-19",
                "Cúm A",
                "Sốt xuất huyết"
        );

        // TreeMap để đếm và sắp xếp theo Alphabet
        Map<String, Integer> thongKe = new TreeMap<>();

        // Đếm số ca
        for (String benh : danhSachBenh) {
            if (thongKe.containsKey(benh)) {
                thongKe.put(benh, thongKe.get(benh) + 1);
            } else {
                thongKe.put(benh, 1);
            }
        }

        // In báo cáo
        System.out.println("Báo cáo dịch tễ:");
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " ca");
        }
    }
}
