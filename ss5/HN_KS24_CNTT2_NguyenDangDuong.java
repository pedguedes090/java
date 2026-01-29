import java.util.*;
public class HN_KS24_CNTT2_NguyenDangDuong {

    public static void main(String[] args) {
        String[] mssvList = new String[100];
        Scanner sc = new Scanner(System.in);
        int size = 0;
        int choice;
        do{
            showMenu();
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    display(mssvList, size);
                    break;
                case 2:
                    size = addNew(sc, mssvList, size);
                    break;
                case 3:
                    update(sc, mssvList, size);
                    break;
                case 4:
                    delete(sc, mssvList, size);
                    break;
                case 5:
                    findStudent(sc, mssvList, size);
                    break;
            }
            }while(true);
    }
    static void showMenu(){
        System.out.println("Menu Chức năng");
        System.out.println("1.Hiển thị danh sách sinh viên");
        System.out.println("2.Thêm mới sinh viên ");
        System.out.println("3.Cập nhật sinh viên ");
        System.out.println("4.Xoá sinh viên ");
        System.out.println("5.Tìm kiếm sinh viên bằng mã sinh viên ");
        System.out.println("6.Thoát");
    };
    static void display(String[] arr, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }

        System.out.println("\nDANH SÁCH MSSV");
        System.out.printf("%-5s %-15s%n", "STT", "MSSV");
        for (int i = 0; i < size; i++) {
            System.out.printf("%-5d %-15s%n", (i + 1), arr[i]);
        }
    }
    static int addNew(Scanner sc, String[] arr, int size) {
        if (size >= 100) {
            System.out.println("Mảng đã đầy (tối đa 100 MSSV). Không thể thêm!");
            return size;
        }

        String newMssv;
        while (true) {
            System.out.print("Nhập MSSV (B + 7 chữ số, ví dụ B2101234): ");
            newMssv = sc.nextLine().trim();
            if (newMssv.matches("^B\\d{7}$")){
                break;}
            System.out.println("Sai định dạng MSSV! Vui lòng nhập lại.");
        }

        arr[size] = newMssv;
        size++;
        System.out.println("Thêm MSSV thành công!");
        return size;
    }
    static void update(Scanner sc, String[] arr, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng. Không có gì để cập nhật.");
            return;
        }
        System.out.print("Nhập index cần sửa ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 0 || index >= size) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        System.out.println("MSSV hiện tại ở index " + index + ": " + arr[index]);
        String newMssv;
        while (true) {
            System.out.print("Nhập MSSV mới (B + 7 chữ số): ");
            newMssv = sc.nextLine().trim();
            if (newMssv.matches("^B\\d{7}$")){
                break;
            }
            System.out.println("Sai định dạng MSSV! Vui lòng nhập lại.");
        }

        arr[index] = newMssv;
        System.out.println("Cập nhật thành công!");
    }
    static void delete(Scanner sc, String[] arr, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng. Không có gì để xoá.");
            return;
        }
        System.out.print("Nhập index cần xoá ");
        int index = sc.nextInt();
        sc.nextLine();
        if (index < 0 || index >= size) {
            System.out.println("Index không hợp lệ!");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            if (arr[i + 1] == null) {
                size--;
                break;
            }
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
        System.out.println("Xoá thành công!");

    }
    static void findStudent(Scanner sc, String[] arr, int size) {
        if (size == 0) {
            System.out.println("Danh sách rỗng.");
            return;
        }
        System.out.print("Nhập MSSV cần tìm: ");
        String key = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (arr[i].toLowerCase().contains(key)) {
                System.out.println("Index " + i + ": " + arr[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không có MSSV nào chứa: \"" + key + "\"");
        }
    }
}
