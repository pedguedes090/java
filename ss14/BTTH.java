import java.util.*;

// ===== Abstract Class =====
abstract class Person {
    protected String id;
    protected String name;
    protected int age;

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }

    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }

    public abstract void displayInfo();
}

// ===== Patient (Comparable) =====
class Patient extends Person implements Comparable<Patient> {
    private String phone;

    public Patient(String id, String name, int age, String phone) {
        super(id, name, age);
        this.phone = phone;
    }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public int compareTo(Patient o) {
        return this.name.compareToIgnoreCase(o.name);
    }

    @Override
    public void displayInfo() {
        System.out.println(id + " - " + name + " - " + age + " - " + phone);
    }
}

// ===== Medical Record =====
class MedicalRecord {
    private String recordId;
    private String diagnosis;
    private String date;

    public MedicalRecord(String recordId, String diagnosis, String date) {
        this.recordId = recordId;
        this.diagnosis = diagnosis;
        this.date = date;
    }

    public String getRecordId() { return recordId; }
    public String getDiagnosis() { return diagnosis; }
    public String getDate() { return date; }

    public void display() {
        System.out.println("Record: " + recordId +
                " | Date: " + date +
                " | Diagnosis: " + diagnosis);
    }
}

// ===== Interface =====
interface Manageable<T> {
    void add(T t);
    void update(String id);
    void delete(String id);
    void displayAll();
}

// ===== Service =====
class PatientService implements Manageable<Patient> {
    private Set<Patient> patients = new HashSet<>();
    private Map<String, List<MedicalRecord>> recordMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    // ===== CRUD Patient =====
    @Override
    public void add(Patient p) {
        for (Patient patient : patients) {
            if (patient.getId().equalsIgnoreCase(p.getId())) {
                System.out.println("ID đã tồn tại!");
                return;
            }
        }
        patients.add(p);
        System.out.println("Thêm thành công!");
    }

    @Override
    public void update(String id) {
        for (Patient p : patients) {
            if (p.getId().equalsIgnoreCase(id)) {
                System.out.print("Tên mới: ");
                p.setName(sc.nextLine());
                System.out.print("Tuổi mới: ");
                p.setAge(Integer.parseInt(sc.nextLine()));
                System.out.print("SĐT mới: ");
                p.setPhone(sc.nextLine());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    @Override
    public void delete(String id) {
        patients.removeIf(p -> p.getId().equalsIgnoreCase(id));
        recordMap.remove(id);
        System.out.println("Đã xóa!");
    }

    @Override
    public void displayAll() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        patients.forEach(Patient::displayInfo);
    }

    // ===== Medical Record =====
    public void addRecord(String patientId) {
        if (!exists(patientId)) {
            System.out.println("Bệnh nhân không tồn tại!");
            return;
        }

        System.out.print("Mã hồ sơ: ");
        String rid = sc.nextLine();
        System.out.print("Chẩn đoán: ");
        String d = sc.nextLine();
        System.out.print("Ngày khám: ");
        String date = sc.nextLine();

        MedicalRecord record = new MedicalRecord(rid, d, date);
        recordMap.computeIfAbsent(patientId, k -> new ArrayList<>()).add(record);
        System.out.println("Thêm hồ sơ thành công!");
    }

    public void viewRecords(String patientId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list == null || list.isEmpty()) {
            System.out.println("Không có hồ sơ!");
            return;
        }
        list.forEach(MedicalRecord::display);
    }

    public void deleteRecord(String patientId, String recordId) {
        List<MedicalRecord> list = recordMap.get(patientId);
        if (list != null) {
            list.removeIf(r -> r.getRecordId().equalsIgnoreCase(recordId));
            System.out.println("Đã xóa hồ sơ!");
        } else {
            System.out.println("Không tìm thấy hồ sơ!");
        }
    }

    // ===== Search =====
    public void searchById(String id) {
        patients.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .forEach(Patient::displayInfo);
    }

    public void searchByName(String keyword) {
        patients.stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(Patient::displayInfo);
    }

    // ===== Sort =====
    public void sortByName() {
        List<Patient> list = new ArrayList<>(patients);
        Collections.sort(list);
        list.forEach(Patient::displayInfo);
    }

    public void sortByAge() {
        List<Patient> list = new ArrayList<>(patients);
        list.sort(Comparator.comparingInt(Patient::getAge));
        list.forEach(Patient::displayInfo);
    }

    public void sortById() {
        List<Patient> list = new ArrayList<>(patients);
        list.sort(Comparator.comparing(Patient::getId));
        list.forEach(Patient::displayInfo);
    }

    private boolean exists(String id) {
        return patients.stream().anyMatch(p -> p.getId().equalsIgnoreCase(id));
    }
}

// ===== Main + Menu =====
public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientService service = new PatientService();

        while (true) {
            System.out.println("\n========= QUẢN LÝ PHÒNG KHÁM =========");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Cập nhật bệnh nhân");
            System.out.println("3. Xóa bệnh nhân");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("5. Thêm hồ sơ khám");
            System.out.println("6. Xem hồ sơ");
            System.out.println("7. Xóa hồ sơ");
            System.out.println("8. Tìm bệnh nhân");
            System.out.println("9. Sắp xếp bệnh nhân");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("SĐT: ");
                    String phone = sc.nextLine();
                    service.add(new Patient(id, name, age, phone));
                    break;

                case 2:
                    System.out.print("Nhập ID: ");
                    service.update(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Nhập ID: ");
                    service.delete(sc.nextLine());
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    System.out.print("ID bệnh nhân: ");
                    service.addRecord(sc.nextLine());
                    break;

                case 6:
                    System.out.print("ID bệnh nhân: ");
                    service.viewRecords(sc.nextLine());
                    break;

                case 7:
                    System.out.print("ID bệnh nhân: ");
                    String pid = sc.nextLine();
                    System.out.print("Mã hồ sơ: ");
                    String rid = sc.nextLine();
                    service.deleteRecord(pid, rid);
                    break;

                case 8:
                    System.out.print("1. Theo ID | 2. Theo tên: ");
                    int s = Integer.parseInt(sc.nextLine());
                    if (s == 1) {
                        System.out.print("Nhập ID: ");
                        service.searchById(sc.nextLine());
                    } else {
                        System.out.print("Nhập tên: ");
                        service.searchByName(sc.nextLine());
                    }
                    break;

                case 9:
                    System.out.print("1.Tên 2.Tuổi 3.ID: ");
                    int sort = Integer.parseInt(sc.nextLine());
                    if (sort == 1) service.sortByName();
                    else if (sort == 2) service.sortByAge();
                    else service.sortById();
                    break;

                case 0:
                    System.out.println("Thoát chương trình!");
                    return;
            }
        }
    }
}
