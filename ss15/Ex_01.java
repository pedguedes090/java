import java.util.Stack;

// Lớp mô tả một lần chỉnh sửa
class EditAction {
    private String description;
    private String time;

    public EditAction(String description, String time) {
        this.description = description;
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return time + " - " + description;
    }
}

// Lớp quản lý lịch sử bệnh án bằng Stack
class MedicalRecordHistory {
    private Stack<EditAction> history = new Stack<>();

    // Thêm chỉnh sửa (push)
    public void addEdit(EditAction action) {
        history.push(action);
        System.out.println("Đã thêm chỉnh sửa: " + action);
    }

    // Hoàn tác (pop)
    public EditAction undoEdit() {
        if (history.isEmpty()) {
            System.out.println("Không có chỉnh sửa nào để Undo!");
            return null;
        }
        EditAction removed = history.pop();
        System.out.println("Đã Undo: " + removed);
        return removed;
    }

    // Xem chỉnh sửa gần nhất (peek)
    public EditAction getLatestEdit() {
        if (history.isEmpty()) {
            System.out.println("Chưa có chỉnh sửa nào.");
            return null;
        }
        return history.peek();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    // Hiển thị toàn bộ lịch sử (từ mới → cũ)
    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("Lịch sử trống.");
            return;
        }

        System.out.println("\nDanh sách chỉnh sửa (mới nhất → cũ nhất):");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println("- " + history.get(i));
        }
    }
}

// Chương trình chính
public class Ex_01 {
    public static void main(String[] args) {
        MedicalRecordHistory history = new MedicalRecordHistory();

        // Thêm chỉnh sửa
        history.addEdit(new EditAction("Thêm chẩn đoán: Cảm cúm", "10:00"));
        history.addEdit(new EditAction("Cập nhật thuốc: Paracetamol", "10:05"));
        history.addEdit(new EditAction("Sửa liều lượng thuốc", "10:10"));

        // Hiển thị lịch sử
        history.displayHistory();

        // Xem chỉnh sửa gần nhất
        System.out.println("\nChỉnh sửa gần nhất: " + history.getLatestEdit());

        // Undo
        history.undoEdit();

        // Hiển thị lại sau Undo
        history.displayHistory();

        // Undo tiếp
        history.undoEdit();
        history.undoEdit();
        history.undoEdit(); // thử khi Stack rỗng
    }
}
