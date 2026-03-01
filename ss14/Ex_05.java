import java.util.*;

// Class Patient
class Patient {
    String name;
    int severity;      // 1: Nguy kịch, 2: Nặng, 3: Nhẹ
    int arrivalTime;

    public Patient(String name, int severity, int arrivalTime) {
        this.name = name;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    // Hiển thị thông tin
    @Override
    public String toString() {
        return name + " (Mức " + severity + ", đến lúc " + arrivalTime + ")";
    }
}

// Comparator để sắp xếp theo quy tắc triage
class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // So sánh severity trước
        if (p1.severity != p2.severity) {
            return p1.severity - p2.severity; // severity nhỏ hơn ưu tiên
        }
        // Nếu cùng severity, so sánh thời gian đến
        return p1.arrivalTime - p2.arrivalTime;
    }
}

public class Ex_05 {
    public static void main(String[] args) {
        // TreeSet với Comparator
        TreeSet<Patient> queue = new TreeSet<>(new PatientComparator());

        // Thêm bệnh nhân (arrivalTime tính bằng phút để dễ so sánh)
        queue.add(new Patient("Bệnh nhân A", 3, 480)); // 8:00
        queue.add(new Patient("Bệnh nhân B", 1, 495)); // 8:15
        queue.add(new Patient("Bệnh nhân C", 1, 485)); // 8:05
        queue.add(new Patient("Bệnh nhân D", 2, 490)); // 8:10

        // In thứ tự xử lý
        System.out.println("Thứ tự xử lý cấp cứu:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
