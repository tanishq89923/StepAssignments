/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 6 - S6 - Classes and Objects Revision - Assignment Practice Problem (HW)
 * Category C - Problem M5: Employee and Company Information Management
 */
public class CompanyEmployee {

    public static class Employee {
        private String empName;
        private double salary;

        // Static members shared across all instances
        public static String companyName = "Bright Horizon Technologies";
        public static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++; // Increment count on each instantiation
        }

        /**
         * Static method accessing only static members.
         */
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem M5: Employee and Company Information Management ---");

        // Instantiating three employees
        Employee emp1 = new Employee("Aarav", 55000);
        Employee emp2 = new Employee("Bhavna", 62000);
        Employee emp3 = new Employee("Chirag", 48000);

        // Accessing static method directly via the Class name
        Employee.printCompanyInfo();
    }
}
