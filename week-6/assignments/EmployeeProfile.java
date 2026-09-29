/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 6 - S6 - Classes and Objects Revision - Assignment Practice Problem (HW)
 * Category C - Problem M3: Employee Profile Creation
 */
public class EmployeeProfile {

    public static class Employee {
        private String empId;
        private String empName;
        private double salary;
        private boolean isIntern;

        /**
         * Constructor for permanent employees.
         *
         * @param empId   Employee ID
         * @param empName Employee Name
         * @param salary  Monthly Salary
         */
        public Employee(String empId, String empName, double salary) {
            if (empId == null || empId.trim().isEmpty()) {
                throw new IllegalArgumentException("Employee ID cannot be empty.");
            }
            if (empName == null || empName.trim().isEmpty()) {
                throw new IllegalArgumentException("Employee Name cannot be empty.");
            }
            this.empId = empId;
            this.empName = empName;
            this.salary = Math.max(0.0, salary);
            this.isIntern = false;
        }

        /**
         * Constructor for interns using this(...) constructor chaining.
         *
         * @param empId   Employee ID
         * @param empName Employee Name
         */
        public Employee(String empId, String empName) {
            this(empId, empName, 0.0);
            this.isIntern = true;
        }

        public void printProfile() {
            System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem M3: Employee Profile Creation ---");

        Employee permEmp = new Employee("E-101", "Divya", 65000);
        Employee internEmp = new Employee("E-102", "Arjun");

        permEmp.printProfile();
        internEmp.printProfile();
    }
}
