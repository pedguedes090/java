package Session7;
class Config {
    public static final double MAX_SCORE = 10.0;
    public static final double MIN_SCORE = 0.0;
}
public class Session7_5 {
    public static void main(String[] args) {
        double score = 8.5;

        if (score >= Config.MIN_SCORE && score <= Config.MAX_SCORE) {
            System.out.println("Diem hop le: " + score);
        } else {
            System.out.println("Diem khong hop le");
        }
    }
}
