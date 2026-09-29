/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 6 - S6 - Classes and Objects Revision - Assignment Practice Problem (HW)
 * Category C - Problem M2: Payroll Salary Management
 */
public class PayrollAccount {

    private double basicSalary;
    private double bonus;

    /**
     * Constructor accepting opening basic salary.
     * If negative, initializes to 0 and prints a warning.
     *
     * @param basicSalary Initial basic salary amount
     */
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initializing to 0.0.");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0;
    }

    /**
     * Credits bonus to account. Rejects amount <= 0 with an informative message.
     *
     * @param amount Bonus amount to credit
     */
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid bonus amount: Must be greater than 0.");
            return;
        }
        this.bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    /**
     * Deducts tax by percentage from basic salary.
     * Rejects percentages outside [0, 100].
     *
     * @param percent Tax percentage to deduct
     */
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Invalid tax percent: Must be between 0 and 100.");
            return;
        }
        double taxAmount = (this.basicSalary * percent) / 100.0;
        this.basicSalary -= taxAmount;
        System.out.println("Tax deducted: " + (int)percent + "%");
    }

    /**
     * Read-only getter returning basicSalary + bonus.
     *
     * @return Current net salary
     */
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem M2: Payroll Salary Management ---");

        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());

        // Test invalid inputs
        System.out.println("\nTesting input validation:");
        account.creditBonus(-1000);
        account.deductTax(150);
    }
}
