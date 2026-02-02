package Session7;
class ClassRoom {
    private static double classFund = 0;
    private String studentName;

    public ClassRoom(String studentName) {
        this.studentName = studentName;
    }

    public void contribute(double amount) {
        if (amount > 0) {
            classFund += amount;
            System.out.println(studentName + " da dong " + amount + " VND");
        } else {
            System.out.println("So tien khong hop le");
        }
    }

    public static void showClassFund() {
        System.out.println("Tong quy lop: " + classFund + " VND");
    }
}
public class Session7_4 {
    public static void main(String[] args) {

        ClassRoom s1 = new ClassRoom("Nguyen Van A");
        ClassRoom s2 = new ClassRoom("Tran Thi B");
        ClassRoom s3 = new ClassRoom("Le Van C");

        s1.contribute(100000);
        s2.contribute(150000);
        s3.contribute(200000);
        ClassRoom.showClassFund();
    }
}
