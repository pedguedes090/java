package Session10;

abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}

interface BonusCalculator {
    double getBonus();
}

class OfficeStaff extends Employee {
    public OfficeStaff(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateSalary() {
        return baseSalary;
    }
}

class Manager extends Employee implements BonusCalculator {
    public Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double getBonus() {
        return baseSalary * 0.2;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + getBonus();
    }
}

public class Session10_5 {
    public static void main(String[] args) {

        Employee emp1 = new OfficeStaff("Trung", 8000);
        Employee emp2 = new Manager("Anh", 15000);

        System.out.println(emp1.name + " - Luong: " + emp1.calculateSalary());
        System.out.println(emp2.name + " - Luong: " + emp2.calculateSalary());
    }
}
