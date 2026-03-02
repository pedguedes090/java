import java.util.*;

// Lớp bệnh nhân cấp cứu
class EmergencyPatient {
    private String id;
    private String name;
    private int priority; // 1: Cấp cứu, 2: Thường
    private int order;    // Thứ tự đến (để giữ FIFO)

    public EmergencyPatient(String id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        String level = (priority == 1) ? "Cấp cứu" : "Thường";
        return id + " - " + name + " [" + level + "]";
    }
}

// Lớp quản lý hàng đợi ưu tiên
class EmergencyQueue {
    private PriorityQueue<EmergencyPatient> queue;
    private int counter = 0; // dùng để đánh số thứ tự đến

    public EmergencyQueue() {
        queue = new PriorityQueue<>(new Comparator<EmergencyPatient>() {
            @Override
            public int compare(EmergencyPatient p1, EmergencyPatient p2) {
                // Ưu tiên theo mức độ
                if (p1.getPriority() != p2.getPriority()) {
                    return p1.getPriority() - p2.getPriority();
                }
                // Nếu cùng mức → FIFO theo order
                return p1.getOrder() - p2.getOrder();
            }
        });
    }

    // Thêm bệnh nhân
    public void addPatient(EmergencyPatient p) {
        p.setOrder(counter++);
        queue.add(p);
        System.out.println("Đã tiếp nhận: " + p);
    }

    // Gọi bệnh nhân tiếp theo
    public EmergencyPatient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân chờ.");
            return null;
        }
        EmergencyPatient p = queue.poll();
        System.out.println("Đang khám: " + p);
        return p;
    }

    // Hiển thị danh sách chờ (theo thứ tự sẽ được khám)
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }

        // Copy ra list để sắp xếp hiển thị
        List<EmergencyPatient> list = new ArrayList<>(queue);
        Collections.sort(list, new Comparator<EmergencyPatient>() {
            @Override
            public int compare(EmergencyPatient p1, EmergencyPatient p2) {
                if (p1.getPriority() != p2.getPriority()) {
                    return p1.getPriority() - p2.getPriority();
                }
                return p1.getOrder() - p2.getOrder();
            }
        });

        System.out.println("\nDanh sách bệnh nhân chờ (theo thứ tự khám):");
        for (EmergencyPatient p : list) {
            System.out.println("- " + p);
        }
    }
}

// Chương trình chính
public class Ex_04 {
    public static void main(String[] args) {
        EmergencyQueue eq = new EmergencyQueue();

        // Thêm bệnh nhân
        eq.addPatient(new EmergencyPatient("BN01", "Nguyen Van A", 2));
        eq.addPatient(new EmergencyPatient("BN02", "Tran Thi B", 1));
        eq.addPatient(new EmergencyPatient("BN03", "Le Van C", 2));
        eq.addPatient(new EmergencyPatient("BN04", "Pham Thi D", 1));

        // Hiển thị danh sách
        eq.displayQueue();

        // Gọi khám
        eq.callNextPatient();
        eq.callNextPatient();

        // Hiển thị lại
        eq.displayQueue();
    }
}
