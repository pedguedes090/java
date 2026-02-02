package Session7;
class Student {
    private String studentId;
    private String studentName;
    private static int totalStudent = 0;

    public Student(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
        totalStudent++;
    }

    public void display() {
        System.out.println("Ma sinh vien: " + studentId);
        System.out.println("Ten sinh vien: " + studentName);
    }

    public static void displayTotalStudent() {
        System.out.println("Tong so sinh vien da tao: " + totalStudent);
    }

}
public class Session7_1 {
    public static void main(String[] args) {
        Student s1 = new Student("B001", "Nguyen Van A");
        Student s2 = new Student("B002", "Tran Thi B");
        Student s3 = new Student("B003", "Le Van C");

        s1.display();
        System.out.println();

        s2.display();
        System.out.println();

        s3.display();
        System.out.println();

        Student.displayTotalStudent();

    }
}
