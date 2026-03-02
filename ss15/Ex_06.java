import java.util.*;

// ===================== PATIENT =====================
class Patient {
    String id;
    String name;
    int age;
    String gender;

    public Patient(String id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + age + ", " + gender + ")";
    }
}

// ===================== PATIENT WAITING QUEUE =====================
class PatientWaitingQueue {
    private Queue<Patient> waitingQueue = new LinkedList<>();
    private int totalPatients = 0;

    public void addPatient(Patient p) {
        waitingQueue.add(p);
        totalPatients++;
    }

    public Patient callNext() {
        if (waitingQueue.isEmpty()) return null;
        totalPatients--;
        return waitingQueue.poll();
    }

    public void display() {
        System.out.println("\nDanh sách chờ khám:");
        for (Patient p : waitingQueue) {
            System.out.println(p);
        }
        System.out.println("Tổng: " + totalPatients);
    }
}

// ===================== EDIT HISTORY (STACK) =====================
class EditAction {
    String description;
    String editedBy;
    String editTime;

    public EditAction(String description, String editedBy, String editTime) {
        this.description = description;
        this.editedBy = editedBy;
        this.editTime = editTime;
    }

    @Override
    public String toString() {
        return editTime + " - " + description + " (by " + editedBy + ")";
    }
}

class MedicalRecordHistory {
    private Stack<EditAction> editStack = new Stack<>();
    private String recordId;

    public MedicalRecordHistory(String recordId) {
        this.recordId = recordId;
    }

    public void addEdit(EditAction e) {
        editStack.push(e);
    }

    public void undoEdit() {
        if (!editStack.isEmpty()) {
            System.out.println("Undo: " + editStack.pop());
        }
    }

    public void display() {
        System.out.println("\nLịch sử bệnh án " + recordId);
        for (int i = editStack.size() - 1; i >= 0; i--) {
            System.out.println(editStack.get(i));
        }
    }
}

// ===================== TICKET SYSTEM =====================
class Ticket {
    int ticketNumber;
    String issuedTime;

    public Ticket(int ticketNumber, String issuedTime) {
        this.ticketNumber = ticketNumber;
        this.issuedTime = issuedTime;
    }

    @Override
    public String toString() {
        return "Số: " + ticketNumber + " (" + issuedTime + ")";
    }
}

class TicketSystem {
    private Queue<Ticket> ticketQueue = new LinkedList<>();
    private int currentNumber = 1;

    public void issueTicket(String time) {
        ticketQueue.add(new Ticket(currentNumber++, time));
    }

    public Ticket callNext() {
        return ticketQueue.poll();
    }

    public void display() {
        System.out.println("\nDanh sách số chờ:");
        for (Ticket t : ticketQueue) {
            System.out.println(t);
        }
    }
}

// ===================== UNDO MANAGER =====================
class InputAction {
    String fieldName;
    String oldValue;
    String newValue;
    String actionTime;

    public InputAction(String fieldName, String oldValue, String newValue, String actionTime) {
        this.fieldName = fieldName;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.actionTime = actionTime;
    }

    @Override
    public String toString() {
        return actionTime + " - " + fieldName +
                ": " + oldValue + " -> " + newValue;
    }
}

class UndoManager {
    private Stack<InputAction> undoStack = new Stack<>();
    private int maxUndoSteps;

    public UndoManager(int maxUndoSteps) {
        this.maxUndoSteps = maxUndoSteps;
    }

    public void addAction(InputAction action) {
        if (undoStack.size() == maxUndoSteps) {
            undoStack.remove(0); // xóa bước cũ nhất
        }
        undoStack.push(action);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            System.out.println("Undo: " + undoStack.pop());
        }
    }

    public void display() {
        System.out.println("\nDanh sách Undo:");
        for (int i = undoStack.size() - 1; i >= 0; i--) {
            System.out.println(undoStack.get(i));
        }
    }
}

// ===================== MAIN DEMO =====================
public class Ex_06 {
    public static void main(String[] args) {

        // Queue bệnh nhân
        PatientWaitingQueue pq = new PatientWaitingQueue();
        pq.addPatient(new Patient("BN01", "Nguyen Van A", 30, "Nam"));
        pq.addPatient(new Patient("BN02", "Tran Thi B", 25, "Nu"));
        pq.display();

        // Stack lịch sử bệnh án
        MedicalRecordHistory history = new MedicalRecordHistory("HS01");
        history.addEdit(new EditAction("Thêm chẩn đoán", "Dr.A", "10:00"));
        history.addEdit(new EditAction("Cập nhật thuốc", "Dr.B", "10:05"));
        history.display();
        history.undoEdit();

        // Hệ thống số
        TicketSystem ts = new TicketSystem();
        ts.issueTicket("09:00");
        ts.issueTicket("09:02");
        ts.display();
        System.out.println("Gọi: " + ts.callNext());

        // Undo nhập liệu
        UndoManager um = new UndoManager(3);
        um.addAction(new InputAction("Tên", "A", "B", "11:00"));
        um.addAction(new InputAction("Tuổi", "20", "21", "11:01"));
        um.display();
        um.undo();
    }
}
