/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 7 - S7 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 3: The Password Checker
 */
public class PasswordChecker {

    // Stored privately and immutably — never exposed via any getter
    private final String password;

    /**
     * Accepts password once upon object creation.
     *
     * @param password Password to evaluate
     */
    public PasswordChecker(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Error: Password cannot be null.");
        }
        this.password = password;
    }

    /**
     * Computes and returns strength rating without exposing the stored password.
     * Rating rules:
     * - Under 6 characters: "Weak"
     * - 6 to 9 characters: "Medium"
     * - 10+ characters: "Strong"
     *
     * @return Strength classification string
     */
    public String getStrength() {
        int length = this.password.length();
        if (length < 6) {
            return "Weak";
        } else if (length <= 9) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: The Password Checker ---");

        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Password (4 chars)  -> Strength: " + pc1.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Password (8 chars)  -> Strength: " + pc2.getStrength());

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Password (10 chars) -> Strength: " + pc3.getStrength());

        PasswordChecker pc4 = new PasswordChecker("SecureP@ssw0rd2026");
        System.out.println("Password (18 chars) -> Strength: " + pc4.getStrength());
    }
}
