/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 2 - S2 - Assignments Problem (HW)
 * Problem 1: ATM PIN Length Validator
 */
public class AtmPinValidator {

    /**
     * Checks if the given ATM PIN is exactly 4 digits long.
     * Uses length() and a single if/else check without loops.
     *
     * @param pin The PIN string to validate
     */
    public static void checkPinLength(String pin) {
        if (pin == null) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
            return;
        }

        int pinLength = pin.length();
        if (pinLength != 4) {
            System.out.println("Invalid PIN - must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: ATM PIN Length Validator ---");

        // Sample Test Cases
        String pin1 = "482";
        System.out.print("Input: \"" + pin1 + "\" -> ");
        checkPinLength(pin1);

        String pin2 = "4820";
        System.out.print("Input: \"" + pin2 + "\" -> ");
        checkPinLength(pin2);

        String pin3 = "12345";
        System.out.print("Input: \"" + pin3 + "\" -> ");
        checkPinLength(pin3);

        String pin4 = null;
        System.out.print("Input: null -> ");
        checkPinLength(pin4);
    }
}
