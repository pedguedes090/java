import java.util.Scanner;

public class Main {
    private static final int MAX = 100;
    private static final Student[] students = new Student[MAX];
    private static int count = 0;

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== QUẢN LÝ ĐIỂM SINH VIÊN =====");
            System.out.println("1. Nhập danh sách sinh viên");
            System.out.println("2. Hiển thị danh sách sinh viên");
            System.out.println("3. Tìm kiếm sinh viên theo Học lực");
            System.out.println("4. Sắp xếp theo học lực giảm dần");
            System.out.println("5. Thoát");
            System.out.println("==================================");
            System.out.print("Chọn chức năng: ");

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputList();
                    break;
                case 2:
                    displayList();
                    break;
                case 3:
                    searchByRank();
                    break;
                case 4:
                    sortByScore();
                    break;
                case 5:
                    System.out.println("Thoat");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
            }
        } while (choice != 5);
    }
    public static void inputList() {
        if (count == MAX) {
            System.out.println("Danh sách đã đầy, không thể thêm nữa!");
            return;
        }

        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập sinh viên thứ " + (i + 1) + ":");

            String id;
            while (true) {
                System.out.print("Nhập mã SV (SVxxx): ");
                id = scanner.nextLine();
                if (id.matches("^SV\\d{3}$")) {
                    break;
                } else {
                    System.out.println("Mã SV không đúng định dạng (Ví dụ: SV001)!");
                }
            }

            System.out.print("Nhập họ tên: ");
            String name = scanner.nextLine();

            System.out.print("Nhập điểm trung bình: ");
            double score = Double.parseDouble(scanner.nextLine());

            students[count] = new Student(id, name, score);
            count++;
        }
    }

    public static void displayList() {
        if (count == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.println("\nDANH SÁCH SINH VIÊN:");
        for (int i = 0; i < count; i++) {
            System.out.println(students[i].toString());
        }
    }

    public static void searchByRank() {
        System.out.print("Nhập loại học lực cần tìm (Gioi/Kha/Trung Binh): ");
        String rank = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            Student s = students[i];
            if (s.getRank().toLowerCase().equals(rank.toLowerCase())) {
                System.out.println(s.toString());
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sinh viên nào xếp loại: " + rank);
    }

    public static void sortByScore() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getScore() < students[j + 1].getScore()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp danh sách theo học lực giảm dần!");
        displayList();
    }
}