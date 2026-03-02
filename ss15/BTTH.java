import java.util.*;

// ================= Interface =================
interface IManagement {
    void add();
    void display();
    void search();
    void sort();
}

// ================= Abstract Class =================
abstract class Person {
    protected String id;
    protected String fullName;
    protected int age;

    public Person(String id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public abstract void showInfo();
}

// ================= Patient =================
class Patient extends Person {
    protected String medicalCondition;
    protected Stack<String> history;

    public Patient(String id, String fullName, int age, String medicalCondition) {
        super(id, fullName, age);
        this.medicalCondition = medicalCondition;
        this.history = new Stack<>();
    }

    public Stack<String> getHistory() {
        return history;
    }

    public void addHistory(String record) {
        history.push(record);
    }

    @Override
    public void showInfo() {
        System.out.println("ID: " + id +
                " | Name: " + fullName +
                " | Age: " + age +
                " | Condition: " + medicalCondition);
    }
}

// ================= Emergency Patient =================
class EmergencyPatient extends Patient {
    private int priorityLevel;

    public EmergencyPatient(String id, String fullName, int age, String medicalCondition, int priorityLevel) {
        super(id, fullName, age, medicalCondition);
        this.priorityLevel = priorityLevel;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    @Override
    public void showInfo() {
        System.out.println("[EMERGENCY] ID: " + id +
                " | Name: " + fullName +
                " | Age: " + age +
                " | Priority: " + priorityLevel +
                " | Condition: " + medicalCondition);
    }
}

// ================= Management =================
public class BTTH implements IManagement {

    private Queue<Patient> queue = new LinkedList<>();
    private Scanner sc = new Scanner(System.in);

    // ========== Add patient ==========
    @Override
    public void add() {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Medical Condition: ");
        String condition = sc.nextLine();

        System.out.print("Is Emergency? (y/n): ");
        String type = sc.nextLine();

        if (type.equalsIgnoreCase("y")) {
            System.out.print("Enter Priority Level (1-5): ");
            int priority = Integer.parseInt(sc.nextLine());
            EmergencyPatient ep = new EmergencyPatient(id, name, age, condition, priority);

            // ưu tiên đưa lên đầu hàng đợi
            LinkedList<Patient> list = (LinkedList<Patient>) queue;
            list.addFirst(ep);
        } else {
            Patient p = new Patient(id, name, age, condition);
            queue.offer(p);
        }

        System.out.println("Added successfully!");
    }

    // ========== Display queue ==========
    @Override
    public void display() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("\n--- Waiting List ---");
        for (Patient p : queue) {
            p.showInfo();
        }
    }

    // ========== Search ==========
    @Override
    public void search() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Enter ID or Name to search: ");
        String key = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Patient p : queue) {
            if (p.getId().toLowerCase().contains(key) ||
                    p.getFullName().toLowerCase().contains(key)) {
                p.showInfo();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found!");
        }
    }

    // ========== Sort ==========
    @Override
    public void sort() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        List<Patient> list = new ArrayList<>(queue);

        System.out.println("1. Sort by Age");
        System.out.println("2. Sort by Priority (Emergency first)");
        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            list.sort(Comparator.comparingInt(Patient::getAge));
        } else {
            list.sort((p1, p2) -> {
                int pr1 = (p1 instanceof EmergencyPatient) ? ((EmergencyPatient) p1).getPriorityLevel() : 0;
                int pr2 = (p2 instanceof EmergencyPatient) ? ((EmergencyPatient) p2).getPriorityLevel() : 0;
                return pr2 - pr1;
            });
        }

        queue.clear();
        queue.addAll(list);
        System.out.println("Sorted successfully!");
    }

    // ========== Call patient ==========
    public void callPatient() {
        if (queue.isEmpty()) {
            System.out.println("No patient in queue!");
            return;
        }

        Patient p = queue.poll();
        System.out.println("\nNow examining:");
        p.showInfo();

        System.out.print("Enter diagnosis/medicine: ");
        String record = sc.nextLine();
        p.addHistory(record);

        System.out.println("Examination completed!");
    }

    // ========== View history ==========
    public void viewHistory() {
        System.out.print("Enter Patient ID: ");
        String id = sc.nextLine();

        for (Patient p : queue) {
            if (p.getId().equalsIgnoreCase(id)) {
                Stack<String> history = p.getHistory();
                if (history.isEmpty()) {
                    System.out.println("No history!");
                } else {
                    System.out.println("Recent history (LIFO):");
                    while (!history.isEmpty()) {
                        System.out.println("- " + history.pop());
                    }
                }
                return;
            }
        }

        System.out.println("Patient not found in queue!");
    }

    // ========== Menu ==========
    public void menu() {
        while (true) {
            System.out.println("\n===== HOSPITAL MANAGEMENT =====");
            System.out.println("1. Add Patient");
            System.out.println("2. Call Patient");
            System.out.println("3. Display Queue");
            System.out.println("4. Search Patient");
            System.out.println("5. Sort Queue");
            System.out.println("6. View History");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: add(); break;
                case 2: callPatient(); break;
                case 3: display(); break;
                case 4: search(); break;
                case 5: sort(); break;
                case 6: viewHistory(); break;
                case 0:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ========== Main ==========
    public static void main(String[] args) {
        BTTH hm = new BTTH();
        hm.menu();
    }
}
