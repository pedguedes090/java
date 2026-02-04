public class Ex_01 {
    static class Person {
        protected String fullName;
        protected int age;

        public Person(String fullName, int age) {
            this.fullName = fullName;
            this.age = age;
        }

        public void displayInfo() {
            System.out.println("Họ tên: " + fullName);
            System.out.println("Tuổi: " + age);
        }
    }
    static class Student extends Person {
        private String studentId;
        private double gpa;

        public Student(String fullName, int age, String studentId, double gpa) {
            super(fullName, age);
            this.studentId = studentId;
            this.gpa = gpa;
        }

        @Override
        public void displayInfo() {
            super.displayInfo();
            System.out.println("Mã sinh viên: " + studentId);
            System.out.println("Điểm trung bình: " + gpa);
        }
    }
    public static void main(String[] args) {
        Student st = new Student(
                "Đinh Quang Huy",
                20,
                "SV001",
                3.5
        );
        st.displayInfo();
    }
}
