import java.util.Scanner;
import java.util.*;
public class BTTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int MAX = 100;              // sức chứa tối đa
        int[] ids = new int[MAX];         // mã sách (duy nhất)
        String[] titles = new String[MAX];// tên sách
        int[] quantities = new int[MAX];  // số lượng tồn
        int size = 0;                     // số sách hiện có

        while (true) {
            System.out.println("\n===== MENU QUAN LY THU VIEN =====");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them sach moi");
            System.out.println("3. Cap nhat so luong (nhap them)");
            System.out.println("4. Xoa sach");
            System.out.println("5. Tim kiem theo ten (tu khoa)");
            System.out.println("6. Sap xep theo so luong (giam dan)");
            System.out.println("0. Thoat");

            int choice;
            System.out.print("Chon: ");
            String line = sc.nextLine().trim();
            choice = Integer.parseInt(line);

            if (choice == 0) {
                System.out.println("Da thoat!");
                break;
            }

            if (choice == 1) {
                // Xem danh sách
                if (size == 0) {
                    System.out.println("Danh sach rong!");
                } else {
                    System.out.println("\nDanh sach sach:");
                    System.out.printf("%-10s | %-40s | %-10s%n", "Ma", "Ten sach", "So luong");
                    System.out.println("---------------------------------------------------------------");
                    for (int i = 0; i < size; i++) {
                        System.out.printf("%-10d | %-40s | %-10d%n", ids[i], titles[i], quantities[i]);
                    }
                }
            } else if (choice == 2) {
                // Thêm sách mới
                if (size == MAX) {
                    System.out.println("Loi: Mang day, khong the them sach moi!");
                    continue;
                }

                int newId;
                while (true) {
                    System.out.print("Nhap ma sach (int): ");
                    String line = sc.nextLine().trim();
                    try {
                        newId = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai! Vui long nhap so nguyen.");
                    }
                }

                // Kiểm tra trùng mã
                boolean existed = false;
                for (int i = 0; i < size; i++) {
                    if (ids[i] == newId) {
                        existed = true;
                        break;
                    }
                }
                if (existed) {
                    System.out.println("Loi: Ma sach da ton tai!");
                    continue;
                }

                System.out.print("Nhap ten sach: ");
                String newTitle = sc.nextLine().trim();

                int newQty;
                while (true) {
                    System.out.print("Nhap so luong (>=0): ");
                    String line = sc.nextLine().trim();
                    try {
                        newQty = Integer.parseInt(line);
                        if (newQty < 0) {
                            System.out.println("So luong phai >= 0!");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai! Vui long nhap so nguyen.");
                    }
                }

                ids[size] = newId;
                titles[size] = newTitle;
                quantities[size] = newQty;
                size++;

                System.out.println("Them sach thanh cong!");
            } else if (choice == 3) {
                // Cập nhật số lượng (nhập thêm)
                if (size == 0) {
                    System.out.println("Danh sach rong!");
                    continue;
                }

                int id;
                while (true) {
                    System.out.print("Nhap ma sach can cap nhat: ");
                    String line = sc.nextLine().trim();
                    try {
                        id = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai! Vui long nhap so nguyen.");
                    }
                }

                int idx = -1;
                for (int i = 0; i < size; i++) {
                    if (ids[i] == id) {
                        idx = i;
                        break;
                    }
                }
                if (idx == -1) {
                    System.out.println("Khong tim thay ma sach!");
                    continue;
                }

                System.out.println("Sach: " + titles[idx] + " | So luong hien tai: " + quantities[idx]);

                int add;
                while (true) {
                    System.out.print("Nhap so luong nhap them (>=0): ");
                    String line = sc.nextLine().trim();
                    try {
                        add = Integer.parseInt(line);
                        if (add < 0) {
                            System.out.println("So luong nhap them phai >= 0!");
                            continue;
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai! Vui long nhap so nguyen.");
                    }
                }

                quantities[idx] += add;
                System.out.println("Cap nhat thanh cong! So luong moi: " + quantities[idx]);
            } else if (choice == 4) {
                // Xóa sách (dồn mảng)
                if (size == 0) {
                    System.out.println("Danh sach rong!");
                    continue;
                }

                int id;
                while (true) {
                    System.out.print("Nhap ma sach can xoa: ");
                    String line = sc.nextLine().trim();
                    try {
                        id = Integer.parseInt(line);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Nhap sai! Vui long nhap so nguyen.");
                    }
                }

                int idx = -1;
                for (int i = 0; i < size; i++) {
                    if (ids[i] == id) {
                        idx = i;
                        break;
                    }
                }

                if (idx == -1) {
                    System.out.println("Khong tim thay ma sach!");
                    continue;
                }

                for (int i = idx; i < size - 1; i++) {
                    ids[i] = ids[i + 1];
                    titles[i] = titles[i + 1];
                    quantities[i] = quantities[i + 1];
                }
                titles[size - 1] = null;
                ids[size - 1] = 0;
                quantities[size - 1] = 0;
                size--;

                System.out.println("Xoa thanh cong!");
            } else if (choice == 5) {
                // Tìm kiếm gần đúng theo từ khóa (contains, không phân biệt hoa/thường)
                if (size == 0) {
                    System.out.println("Danh sach rong!");
                    continue;
                }

                System.out.print("Nhap tu khoa: ");
                String keyword = sc.nextLine().trim().toLowerCase();

                if (keyword.isEmpty()) {
                    System.out.println("Tu khoa rong!");
                    continue;
                }

                System.out.println("\nKet qua tim kiem:");
                System.out.printf("%-10s | %-40s | %-10s%n", "Ma", "Ten sach", "So luong");
                System.out.println("---------------------------------------------------------------");

                boolean found = false;
                for (int i = 0; i < size; i++) {
                    String t = (titles[i] == null) ? "" : titles[i].toLowerCase();
                    if (t.contains(keyword)) {
                        System.out.printf("%-10d | %-40s | %-10d%n", ids[i], titles[i], quantities[i]);
                        found = true;
                    }
                }
                if (!found) System.out.println("Khong co sach nao phu hop.");
            } else if (choice == 6) {
                // Sắp xếp theo số lượng giảm dần (đổi chỗ đồng bộ 3 mảng)
                if (size <= 1) {
                    System.out.println("Khong can sap xep (danh sach rong hoac chi co 1 sach).");
                    continue;
                }

                for (int i = 0; i < size - 1; i++) {
                    boolean swapped = false;
                    for (int j = 0; j < size - 1 - i; j++) {
                        if (quantities[j] < quantities[j + 1]) {
                            // swap quantities
                            int tmpQ = quantities[j];
                            quantities[j] = quantities[j + 1];
                            quantities[j + 1] = tmpQ;

                            // swap ids
                            int tmpId = ids[j];
                            ids[j] = ids[j + 1];
                            ids[j + 1] = tmpId;

                            // swap titles
                            String tmpT = titles[j];
                            titles[j] = titles[j + 1];
                            titles[j + 1] = tmpT;

                            swapped = true;
                        }
                    }
                    if (!swapped) break;
                }

                System.out.println("Sap xep thanh cong (giam dan theo so luong)!");
            } else {
                System.out.println("Lua chon khong hop le!");
            }
        }

        sc.close();
    }
}
