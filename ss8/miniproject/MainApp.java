import java.util.Scanner;

public class MainApp {
    private static StudentManager manager = new StudentManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Thêm SV |" +
                    " 2. Hiển thị |" +
                    " 3. Tìm kiếm |" +
                    " 4. Cập nhật |" +
                    " 5. Xóa");
            System.out.println("6. Tính ĐTB & Xếp loại (Xem chi tiết) | 7. Sắp xếp | 8. Thống kê | 9. Thoát");
            System.out.print("Chọn (1-9): ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addAction(); break;
                case 2: manager.displayAll(); break;
                case 3:
                    System.out.print("Nhập mã hoặc tên: ");
                    manager.search(sc.nextLine());
                    break;
                case 4: updateAction(); break;
                case 5: deleteAction(); break;
                case 6: detailAction(); break;
                case 7: sortAction(); break;
                case 8: manager.report(); break;
                case 9: System.exit(0);
            }
        }
    }

    private static void addAction() {
        System.out.print("Mã SV: "); String id = sc.nextLine();
        System.out.print("Họ tên: "); String name = sc.nextLine();
        System.out.print("Tuổi: "); int age = Integer.parseInt(sc.nextLine());
        System.out.print("Giới tính: "); String gender = sc.nextLine();
        System.out.print("Điểm Toán, Lý, Hóa (cách nhau khoảng trắng): ");
        double m = sc.nextDouble(); double p = sc.nextDouble(); double c = sc.nextDouble();
        sc.nextLine(); // clear buffer

        if (manager.addStudent(new Student(id, name, age, gender, m, p, c)))
            System.out.println("Thành công!");
        else System.out.println("Thất bại (Trùng mã hoặc đầy)!");
    }

    private static void updateAction() {
        System.out.print("Nhập mã SV cần sửa: ");
        Student s = manager.findById(sc.nextLine());
        if (s != null) {
            System.out.print("Tên mới: "); s.setName(sc.nextLine());
            System.out.print("Điểm Toán mới: "); double m = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Lý mới: "); double p = Double.parseDouble(sc.nextLine());
            System.out.print("Điểm Hóa mới: "); double c = Double.parseDouble(sc.nextLine());
            s.setScores(m, p, c);
            System.out.println("Cập nhật thành công!");
        } else System.out.println("Không tìm thấy!");
    }

    private static void deleteAction() {
        System.out.print("Nhập mã SV cần xóa: ");
        String id = sc.nextLine();
        System.out.print("Xác nhận xóa (Y/N)? ");
        if (sc.nextLine().equalsIgnoreCase("Y")) {
            if (manager.deleteById(id)) System.out.println("Đã xóa.");
            else System.out.println("Không tìm thấy.");
        }
    }

    private static void detailAction() {
        System.out.print("Nhập mã SV xem chi tiết xếp loại: ");
        Student s = manager.findById(sc.nextLine());
        if (s != null) {
            System.out.println("Kết quả: " + s.getName() + " - ĐTB: " + s.getAverage() + " - Loại: " + s.getRank());
        } else System.out.println("Không tìm thấy.");
    }

    private static void sortAction() {
        System.out.println("1. Theo ĐTB giảm dần | 2. Theo tên A-Z");
        int sub = Integer.parseInt(sc.nextLine());
        if (sub == 1) manager.sortByGPA(); else manager.sortByName();
        System.out.println("Đã sắp xếp.");
    }
}