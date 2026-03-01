import java.util.*;

// Class Patient
class Patient {
    String name;
    int age;
    String department;

    public Patient(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    @Override
    public String toString() {
        return name + " (" + age + " tuổi)";
    }
}

public class Ex_06 {
    public static void main(String[] args) {

        // Danh sách bệnh nhân ban đầu
        List<Patient> list = Arrays.asList(
                new Patient("Lan", 30, "Tim mạch"),
                new Patient("Hùng", 45, "Nội tiết"),
                new Patient("Mai", 28, "Tim mạch"),
                new Patient("Tuấn", 50, "Hô hấp")
        );

        // Map: Khoa -> Danh sách bệnh nhân
        Map<String, List<Patient>> map = new HashMap<>();

        // Gom nhóm theo khoa
        for (Patient p : list) {
            if (!map.containsKey(p.department)) {
                map.put(p.department, new ArrayList<>());
            }
            map.get(p.department).add(p);
        }

        // In cấu trúc Map
        System.out.println("Danh sách bệnh nhân theo khoa:");
        for (String khoa : map.keySet()) {
            System.out.println("Khoa " + khoa + ": " + map.get(khoa));
        }

        // Hiển thị bệnh nhân của một khoa bất kỳ
        String khoaCanXem = "Tim mạch";
        System.out.println("\nBệnh nhân khoa " + khoaCanXem + ":");
        if (map.containsKey(khoaCanXem)) {
            for (Patient p : map.get(khoaCanXem)) {
                System.out.println(p);
            }
        } else {
            System.out.println("Không có khoa này.");
        }

        // Tìm khoa đông bệnh nhân nhất
        String khoaDongNhat = "";
        int max = 0;

        for (Map.Entry<String, List<Patient>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                khoaDongNhat = entry.getKey();
            }
        }

        System.out.println("\nKhoa " + khoaDongNhat +
                " đang đông nhất (" + max + " bệnh nhân)");
    }
}
