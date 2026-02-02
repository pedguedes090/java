package Session7;
class ScoreUtils {
    public static boolean isPass(double score) {
        return score >= 5.0;
    }

    public static double average(double sc1, double sc2, double sc3) {
        return (sc1 + sc2 + sc3) / 3;
    }
}
public class Session7_3 {
    public static void main(String[] args) {
        double s1 = 6.5;
        double s2 = 7.0;
        double s3 = 4.5;

        double avg = ScoreUtils.average(s1, s2, s3);
        boolean pass = ScoreUtils.isPass(avg);

        System.out.println("Diem trung binh: " + avg);
        if (pass) {
            System.out.println("Ket qua: DAT");
        } else {
            System.out.println("Ket qua: KHONG DAT");
        }
    }
}
