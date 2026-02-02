package Session7;

class Students {
    String name;

    Students(String name) {
        this.name = name;
    }
}

public class Session7_2 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        b = 20;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        Students s1 = new Students("Nguyen Van A");
        Students s2 = s1;
        s2.name = "Tran Thi B";

        System.out.println("s1.name = " + s1.name);
        System.out.println("s2.name = " + s2.name);
    }
}
