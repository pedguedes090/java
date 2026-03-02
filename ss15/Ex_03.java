import java.util.Stack;

// Lớp kiểm tra quy trình phát thuốc
class MedicationProcessChecker {
    private Stack<String> stack = new Stack<>();

    // Kiểm tra quy trình
    public boolean checkProcess(String[] actions) {
        reset(); // đảm bảo Stack rỗng trước khi kiểm tra

        System.out.println("Bắt đầu kiểm tra quy trình...\n");

        for (int i = 0; i < actions.length; i++) {
            String action = actions[i];

            if (action.equalsIgnoreCase("PUSH")) {
                stack.push("Thuoc");
                System.out.println("Bước " + (i + 1) + ": PUSH -> Phát thuốc");

            } else if (action.equalsIgnoreCase("POP")) {
                if (stack.isEmpty()) {
                    System.out.println("Lỗi tại bước " + (i + 1) +
                            ": POP khi chưa có thuốc nào được phát!");
                    return false;
                }
                stack.pop();
                System.out.println("Bước " + (i + 1) + ": POP -> Hoàn tất");

            } else {
                System.out.println("Lỗi: Hành động không hợp lệ tại bước " + (i + 1));
                return false;
            }
        }

        // Kiểm tra cuối ca
        if (!stack.isEmpty()) {
            System.out.println("\nLỗi: Kết thúc ca nhưng còn "
                    + stack.size() + " thuốc chưa hoàn tất!");
            return false;
        }

        System.out.println("\nQuy trình hợp lệ. Ca trực hoàn tất đúng.");
        return true;
    }

    // Reset Stack
    public void reset() {
        stack.clear();
    }
}

// Chương trình chính
public class Ex_03 {
    public static void main(String[] args) {
        MedicationProcessChecker checker = new MedicationProcessChecker();

        // Test 1: Hợp lệ
        String[] process1 = {"PUSH", "PUSH", "POP", "POP"};
        System.out.println("=== Kiểm tra ca trực 1 ===");
        checker.checkProcess(process1);

        // Test 2: Lỗi POP khi rỗng
        String[] process2 = {"POP", "PUSH"};
        System.out.println("\n=== Kiểm tra ca trực 2 ===");
        checker.checkProcess(process2);

        // Test 3: Kết thúc nhưng chưa POP hết
        String[] process3 = {"PUSH", "PUSH", "POP"};
        System.out.println("\n=== Kiểm tra ca trực 3 ===");
        checker.checkProcess(process3);
    }
}
