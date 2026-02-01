package Session6;
class Employee{
    private String id;
    private String name;
    private int salary;

    public Employee() {
        id = "";
        name = "";
        salary = 0;
    }
    public Employee(String id, String name ){
        this.id = id;
        this.name = name;
        salary = 0;

    }
    public Employee(String id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;

    }
    public void Display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}

public class Session6_4 {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "John Doe", 10000);
        Employee e2 = new Employee();
        Employee e3 = new Employee("2", "John Doe");
        e1.Display();
        e2.Display();
        e3.Display();
    }
}
