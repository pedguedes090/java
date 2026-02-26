import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Medicine {
    private final String drugId;
    private final String drugName;
    private final double unitPrice;
    private int quantity;

    public Medicine(String drugId, String drugName, double unitPrice, int quantity) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getDrugId() {
        return drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addQuantity(int amount) {
        this.quantity += amount;
    }

    public double getSubtotal() {
        return unitPrice * quantity;
    }
}

public class Bai6 {
    static List<Medicine> prescription = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            menu();
            System.out.print("Chon chuc nang: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addMedicine();
                    break;
                case 2:
                    updateQuantity();
                    break;
                case 3:
                    deleteMedicine();
                    break;
                case 4:
                    printInvoice();
                    break;
                case 5:
                    findCheapMedicines();
                    break;
                case 6:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (choice != 6);
    }

    // ===== MENU =====
    static void menu() {
        System.out.println("\n====== MENU ======");
        System.out.println("1. Them thuoc");
        System.out.println("2. Dieu chinh so luong");
        System.out.println("3. Xoa thuoc");
        System.out.println("4. In hoa don");
        System.out.println("5. Tim thuoc gia re (<50000)");
        System.out.println("6. Thoat");
        System.out.println("==================");
    }

    // ===== Tim thuoc theo ID =====
    static Medicine findById(String id) {
        for (Medicine m : prescription) {
            if (m.getDrugId().equals(id)) {
                return m;
            }
        }
        return null;
    }

    static void addMedicine() {
        System.out.print("Nhap ma thuoc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);

        System.out.print("Nhap ten thuoc: ");
        String name = sc.nextLine();

        System.out.print("Nhap don gia: ");
        double price = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so luong: ");
        int qty = Integer.parseInt(sc.nextLine());

        if (m != null) {
            m.addQuantity(qty);
        } else {
            prescription.add(new Medicine(id, name, price, qty));
        }

        System.out.println("Them thuoc thanh cong!");
    }

    static void updateQuantity() {
        System.out.print("Nhap ma thuoc: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m == null) {
            System.out.println("Khong tim thay thuoc.");
            return;
        }

        System.out.print("Nhap so luong moi: ");
        int qty = Integer.parseInt(sc.nextLine());

        if (qty == 0) {
            prescription.remove(m);
        } else {
            m.setQuantity(qty);
        }

        System.out.println("Cap nhat thanh cong!");
    }

    static void deleteMedicine() {
        System.out.print("Nhap ma thuoc can xoa: ");
        String id = sc.nextLine();

        Medicine m = findById(id);
        if (m != null) {
            prescription.remove(m);
            System.out.println("Da xoa thuoc.");
        } else {
            System.out.println("Khong tim thay thuoc.");
        }
    }

    // ===== 4. In hoa don =====
    static void printInvoice() {
        if (prescription.isEmpty()) {
            System.out.println("Don thuoc rong!");
            return;
        }

        double total = 0;

        System.out.println("\n----- HOA DON -----");
        System.out.printf("%-10s %-20s %-10s %-10s %-12s\n",
                "Ma", "Ten", "Gia", "SL", "Thanh tien");

        for (Medicine m : prescription) {
            System.out.printf("%-10s %-20s %-10.0f %-10d %-12.0f\n",
                    m.getDrugId(),
                    m.getDrugName(),
                    m.getUnitPrice(),
                    m.getQuantity(),
                    m.getSubtotal());

            total += m.getSubtotal();
        }

        System.out.println("-------------------------------");
        System.out.printf("Tong tien: %.0f VND\n", total);
    }

    // ===== 5. Tim thuoc gia re =====
    static void findCheapMedicines() {
        boolean found = false;

        System.out.println("\nThuoc gia re (<50000):");
        for (Medicine m : prescription) {
            if (m.getUnitPrice() < 50000) {
                System.out.println(m.getDrugId() + " - " + m.getDrugName()
                        + " - Gia: " + m.getUnitPrice());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Khong co thuoc gia re.");
        }
    }
}