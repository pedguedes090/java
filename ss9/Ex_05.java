public class Ex_05 {
    static abstract class Employee {
        protected String name;

        public Employee(String name) {
            this.name = name;
        }
        public abstract double calculateSalary();
    }
    static class OfficeEmployee extends Employee {
        private double basicSalary;

        public OfficeEmployee(String name, double basicSalary) {
            super(name);
            this.basicSalary = basicSalary;
        }

        @Override
        public double calculateSalary() {
            return basicSalary;
        }
    }
    static class ProductionEmployee extends Employee {
        private int productCount;
        private double salaryPerProduct;

        public ProductionEmployee(String name, int productCount, double salaryPerProduct) {
            super(name);
            this.productCount = productCount;
            this.salaryPerProduct = salaryPerProduct;
        }

        @Override
        public double calculateSalary() {
            return productCount * salaryPerProduct;
        }
    }
    public static void main(String[] args) {

        Employee[] employees = new Employee[2];
        employees[0] = new OfficeEmployee("Huy", 15000000);
        employees[1] = new ProductionEmployee("Nam", 120, 50000);

        double totalSalary = 0;

        for (Employee e : employees) {
            double salary = e.calculateSalary();
            System.out.println("Lương của " + e.name + ": " + salary);
            totalSalary += salary;
        }

        System.out.println("Tổng lương: " + totalSalary);
    }
}
