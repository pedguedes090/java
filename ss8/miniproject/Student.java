public class Student {
    private String id;
    private String name;
    private int age;
    private String gender;
    private double math, physics, chemistry;
    private double average;
    private String rank;

    public Student(String id, String name, int age, String gender, double math, double physics, double chemistry) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        updateStatus();
    }

    // [FR6] Logic tính điểm và xếp loại
    public void updateStatus() {
        this.average = (math + physics + chemistry) / 3;
        if (average >= 8.0 && math >= 6.5 && physics >= 6.5 && chemistry >= 6.5) {
            this.rank = "Giỏi";
        } else if (average >= 6.5 && math >= 5.0 && physics >= 5.0 && chemistry >= 5.0) {
            this.rank = "Khá";
        } else if (average >= 5.0 && math >= 3.5 && physics >= 3.5 && chemistry >= 3.5) {
            this.rank = "Trung bình";
        } else {
            this.rank = "Yếu";
        }
    }

    // Getters và Setters
    public String getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public void setScores(double m, double p, double c) {
        this.math = m; this.physics = p; this.chemistry = c;
        updateStatus();
    }
    public double getAverage() { return average; }
    public String getRank() { return rank; }

    @Override
    public String toString() {
        return String.format("| %-8s | %-18s | %-4d | %-8s | %-8.2f | %-10s |",
                id, name, age, gender, average, rank);
    }
}