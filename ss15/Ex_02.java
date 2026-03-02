import java.util.*;

// Lớp Patient
class Patient {
    private String id;
    private String name;
    private int age;

    public Patient(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + age + " tuổi)";
    }
}

// Lớp quản lý hàng đợi bệnh nhân
class PatientQueue {
    private Queue<Patient> queue = new LinkedList<>();

    // Thêm bệnh nhân (enqueue)
    public void addPatient(Patient p) {
        queue.add(p);
        System.out.println("Đã thêm bệnh nhân: " + p);
    }

    // Gọi bệnh nhân tiếp theo (dequeue)
    public Patient callNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân trong hàng đợi!");
            return null;
        }
        Patient p = queue.poll();
        System.out.println("Đang khám: " + p);
        return p;
    }

    // Xem bệnh nhân tiếp theo (peek)
    public Patient peekNextPatient() {
        if (queue.isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return null;
        }
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Hiển thị danh sách chờ
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Không có bệnh nhân đang chờ.");
            return;
        }

        System.out.println("\nDanh sách bệnh nhân đang chờ (FIFO):");
        for (Patient p : queue) {
            System.out.println("- " + p);
        }
    }
}

// Chương trình chính
public class Ex_02 {
    public static void main(String[] args) {
        PatientQueue queue = new PatientQueue();

        // Thêm bệnh nhân
        queue.addPatient(new Patient("BN01", "Nguyen Van A", 30));
        queue.addPatient(new Patient("BN02", "Tran Thi B", 25));
        queue.addPatient(new Patient("BN03", "Le Van C", 40));

        // Hiển thị hàng đợi
        queue.displayQueue();

        // Xem người tiếp theo
        System.out.println("\nBệnh nhân sắp được khám: " + queue.peekNextPatient());

        // Gọi khám
        queue.callNextPatient();

        // Hiển thị lại
        queue.displayQueue();

        // Gọi tiếp
        queue.callNextPatient();
        queue.callNextPatient();
        queue.callNextPatient(); // thử khi rỗng
    }
}
