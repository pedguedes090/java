import java.util.*;

// Lớp Patient
class Patient {
    private String id;
    private String name;

    public Patient(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}

// Bước xử lý
class TreatmentStep {
    private String description;
    private String time;

    public TreatmentStep(String description, String time) {
        this.description = description;
        this.time = time;
    }

    @Override
    public String toString() {
        return time + " - " + description;
    }
}

// Hồ sơ cấp cứu của 1 bệnh nhân
class EmergencyCase {
    private Patient patient;
    private Stack<TreatmentStep> steps = new Stack<>();

    public EmergencyCase(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    // Thêm bước xử lý (push)
    public void addStep(TreatmentStep step) {
        steps.push(step);
        System.out.println("Đã thêm bước: " + step);
    }

    // Undo bước gần nhất (pop)
    public TreatmentStep undoStep() {
        if (steps.isEmpty()) {
            System.out.println("Không có bước nào để Undo!");
            return null;
        }
        TreatmentStep removed = steps.pop();
        System.out.println("Đã Undo: " + removed);
        return removed;
    }

    // Hiển thị các bước (mới nhất → cũ nhất)
    public void displaySteps() {
        if (steps.isEmpty()) {
            System.out.println("Chưa có bước xử lý.");
            return;
        }

        System.out.println("Các bước xử lý của bệnh nhân " + patient + ":");
        for (int i = steps.size() - 1; i >= 0; i--) {
            System.out.println("- " + steps.get(i));
        }
    }
}

// Hàng đợi cấp cứu
class EmergencyCaseQueue {
    private Queue<EmergencyCase> cases = new LinkedList<>();

    // Thêm ca vào hàng đợi
    public void addCase(EmergencyCase c) {
        cases.add(c);
        System.out.println("Đã tiếp nhận bệnh nhân: " + c.getPatient());
    }

    // Lấy ca tiếp theo
    public EmergencyCase getNextCase() {
        if (cases.isEmpty()) {
            System.out.println("Không còn bệnh nhân chờ.");
            return null;
        }
        EmergencyCase c = cases.poll();
        System.out.println("\nĐang xử lý: " + c.getPatient());
        return c;
    }

    public void displayQueue() {
        if (cases.isEmpty()) {
            System.out.println("Hàng đợi trống.");
            return;
        }

        System.out.println("\nDanh sách bệnh nhân chờ:");
        for (EmergencyCase c : cases) {
            System.out.println("- " + c.getPatient());
        }
    }
}

// Chương trình chính
public class Ex_05 {
    public static void main(String[] args) {

        EmergencyCaseQueue queue = new EmergencyCaseQueue();

        // Thêm bệnh nhân vào Queue
        queue.addCase(new EmergencyCase(new Patient("BN01", "Nguyen Van A")));
        queue.addCase(new EmergencyCase(new Patient("BN02", "Tran Thi B")));
        queue.addCase(new EmergencyCase(new Patient("BN03", "Le Van C")));

        queue.displayQueue();

        // Lấy bệnh nhân đầu tiên để xử lý
        EmergencyCase currentCase = queue.getNextCase();

        if (currentCase != null) {
            // Thêm các bước xử lý (Stack)
            currentCase.addStep(new TreatmentStep("Tiếp nhận bệnh nhân", "10:00"));
            currentCase.addStep(new TreatmentStep("Đo huyết áp", "10:02"));
            currentCase.addStep(new TreatmentStep("Chẩn đoán ban đầu", "10:05"));

            // Hiển thị
            currentCase.displaySteps();

            // Undo bước sai
            currentCase.undoStep();

            // Hiển thị lại
            currentCase.displaySteps();
        }

        // Xử lý bệnh nhân tiếp theo
        EmergencyCase nextCase = queue.getNextCase();
        if (nextCase != null) {
            nextCase.addStep(new TreatmentStep("Tiếp nhận bệnh nhân", "10:10"));
            nextCase.displaySteps();
        }

        // Hiển thị Queue còn lại
        queue.displayQueue();
    }
}
