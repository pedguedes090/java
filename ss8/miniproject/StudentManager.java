public class StudentManager {
    private Student[] students = new Student[100];
    private int count = 0;

    // [FR1] Thêm sinh viên (Kiểm tra trùng mã)
    public boolean addStudent(Student s) {
        if (count >= 100 || findById(s.getId()) != null) return false;
        students[count++] = s;
        return true;
    }

    // [FR2] Hiển thị danh sách
    public void displayAll() {
        if (count == 0) { System.out.println("Danh sách trống!"); return; }
        printHeader();
        for (int i = 0; i < count; i++) System.out.println(students[i]);
    }

    // [FR3] Tìm kiếm (Mã chính xác hoặc Tên chứa từ khóa)
    public void search(String keyword) {
        boolean found = false;
        printHeader();
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(keyword) ||
                    students[i].getName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy kết quả nào.");
    }

    public Student findById(String id) {
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) return students[i];
        }
        return null;
    }

    // [FR5] Xóa sinh viên (Dịch chuyển mảng)
    public boolean deleteById(String id) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (students[i].getId().equalsIgnoreCase(id)) { index = i; break; }
        }
        if (index != -1) {
            for (int i = index; i < count - 1; i++) students[i] = students[i + 1];
            students[--count] = null;
            return true;
        }
        return false;
    }

    // [FR7] Sắp xếp
    public void sortByGPA() { // Bubble Sort
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (students[j].getAverage() < students[j+1].getAverage()) {
                    Student temp = students[j]; students[j] = students[j+1]; students[j+1] = temp;
                }
            }
        }
    }

    public void sortByName() { // Selection Sort
        for (int i = 0; i < count - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < count; j++) {
                if (students[j].getName().compareToIgnoreCase(students[minIdx].getName()) < 0) minIdx = j;
            }
            Student temp = students[minIdx]; students[minIdx] = students[i]; students[i] = temp;
        }
    }

    // [FR8] Thống kê
    public void report() {
        if (count == 0) return;
        int g = 0, k = 0, tb = 0, y = 0;
        Student max = students[0], min = students[0];
        double sum = 0;

        for (int i = 0; i < count; i++) {
            String r = students[i].getRank();
            if (r.equals("Giỏi")) g++; else if (r.equals("Khá")) k++;
            else if (r.equals("Trung bình")) tb++; else y++;

            if (students[i].getAverage() > max.getAverage()) max = students[i];
            if (students[i].getAverage() < min.getAverage()) min = students[i];
            sum += students[i].getAverage();
        }

        System.out.println("--- BÁO CÁO THỐNG KÊ ---");
        System.out.printf("Xếp loại: Giỏi:%d | Khá:%d | TB:%d | Yếu:%d\n", g, k, tb, y);
        System.out.println("SV cao điểm nhất: " + max.getName() + " (" + String.format("%.2f", max.getAverage()) + ")");
        System.out.println("SV thấp điểm nhất: " + min.getName() + " (" + String.format("%.2f", min.getAverage()) + ")");
        System.out.printf("Điểm TB chung hệ thống: %.2f\n", (sum / count));
    }

    private void printHeader() {
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("| Mã SV    | Họ tên             | Tuổi | Giới tính | Điểm TB  | Xếp loại   |");
        System.out.println("---------------------------------------------------------------------------");
    }
}