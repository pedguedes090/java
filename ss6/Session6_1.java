package Session6;


    class Student{
        private String studentId;
        private String name;
        private int yearBorn;
        private int avgPoint;
        public Student(String studentId , String name, int yearBorn , int avgPoint){
            this.studentId = studentId;
            this.name = name;
            this.yearBorn = yearBorn;
            this.avgPoint = avgPoint;
        }
        public  void Display(){
            System.out.println("Student id: : " + studentId);
            System.out.println("Student Name: " + name);
            System.out.println("Student Year Born: " + yearBorn);
            System.out.println("Student Avg Point: " + avgPoint);
        }
    }

public class Session6_1 {
    public static void main(String[] args) {
        Student s1 = new Student("1","Mai duy ann",2006,10);
        Student s2 = new Student("2","Mai duy em",2006,10);
        s1.Display();
        s2.Display();
    }
}
