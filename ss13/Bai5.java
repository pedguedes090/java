import java.util.Scanner;
import java.util.*;
class Patient {
    private final int id;
    private String name;
    private int age;
    private String gender;
    private String disease;

    public Patient(int id, String name, int age, String gender, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDisease() {
        return disease;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public void display() {
        System.out.println("ID: " + id +
                " | Tên: " + name +
                " | Tuổi: " + age +
                " | Giới tính: " + gender +
                " | Bệnh: " + disease);
    }
}

class PatientManager {
    private final List<Patient> patients = new ArrayList<>();

    // Thêm bệnh nhân
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Thêm bệnh nhân thành công!");
    }

    public void removePatient(int id) {
        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("Xóa thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    public void updatePatient(int id, Patient updatedPatient) {
        for (Patient p : patients) {
            if (p.getId() == id) {
                p.setName(updatedPatient.getName());
                p.setAge(updatedPatient.getAge());
                p.setGender(updatedPatient.getGender());
                p.setDisease(updatedPatient.getDisease());
                System.out.println("Cập nhật thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân!");
    }

    public void searchPatientByName(String name) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                p.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy bệnh nhân!");
        }
    }

    public void sortPatientsByAge(boolean ascending) {
        patients.sort((p1, p2) -> ascending ?
                p1.getAge() - p2.getAge() :
                p2.getAge() - p1.getAge());
        System.out.println("Đã sắp xếp theo tuổi!");
    }

    public void sortPatientsByName(boolean ascending) {
        patients.sort((p1, p2) -> ascending ?
                p1.getName().compareToIgnoreCase(p2.getName()) :
                p2.getName().compareToIgnoreCase(p1.getName()));
        System.out.println("Đã sắp xếp theo tên!");
    }

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }
        for (Patient p : patients) {
            p.display();
        }
    }
}

public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PatientManager manager = new PatientManager();
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ BỆNH NHÂN =====");
            System.out.println("1. Thêm bệnh nhân");
            System.out.println("2. Xóa bệnh nhân");
            System.out.println("3. Cập nhật bệnh nhân");
            System.out.println("4. Tìm bệnh nhân theo tên");
            System.out.println("5. Sắp xếp theo tuổi");
            System.out.println("6. Sắp xếp theo tên");
            System.out.println("7. Hiển thị danh sách");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tên: ");
                    String name = sc.nextLine();
                    System.out.print("Tuổi: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Giới tính: ");
                    String gender = sc.nextLine();
                    System.out.print("Bệnh: ");
                    String disease = sc.nextLine();

                    manager.addPatient(new Patient(id, name, age, gender, disease));
                    break;

                case 2:
                    System.out.print("Nhập ID cần xóa: ");
                    manager.removePatient(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Nhập ID cần cập nhật: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Tên mới: ");
                    String newName = sc.nextLine();
                    System.out.print("Tuổi mới: ");
                    int newAge = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Giới tính mới: ");
                    String newGender = sc.nextLine();
                    System.out.print("Bệnh mới: ");
                    String newDisease = sc.nextLine();

                    manager.updatePatient(updateId,
                            new Patient(updateId, newName, newAge, newGender, newDisease));
                    break;

                case 4:
                    System.out.print("Nhập tên cần tìm: ");
                    String searchName = sc.nextLine();
                    manager.searchPatientByName(searchName);
                    break;

                case 5:
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    int ageChoice = sc.nextInt();
                    manager.sortPatientsByAge(ageChoice == 1);
                    break;

                case 6:
                    System.out.println("1. A -> Z");
                    System.out.println("2. Z -> A");
                    int nameChoice = sc.nextInt();
                    manager.sortPatientsByName(nameChoice == 1);
                    break;

                case 7:
                    manager.displayPatients();
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}