import java.util.Locale;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 1 - S1 - Assignments Problem (HW)
 * Problem 2: The Typing Speed Test Accuracy Checker
 */
public class TypingSpeedAccuracyChecker {

    /**
     * Compares original text and typed text character by character,
     * computes accuracy, and identifies the first mismatch.
     *
     * @param original Original reference passage
     * @param typed    User typed passage
     */
    public static void checkTypingAccuracy(String original, String typed) {
        if (original == null || typed == null) {
            throw new IllegalArgumentException("Error: Original and typed passages cannot be null.");
        }

        if (original.length() != typed.length()) {
            throw new IllegalArgumentException("Error: String lengths must be equal for comparison. " +
                    "Original length: " + original.length() + ", Typed length: " + typed.length());
        }

        int totalLength = original.length();
        if (totalLength == 0) {
            System.out.println("Matched: 0/0 | Accuracy: 100.00% | No Mismatches");
            return;
        }

        int matchCount = 0;
        int firstMismatchPos = -1;
        char origCharMismatch = ' ';
        char typedCharMismatch = ' ';

        for (int i = 0; i < totalLength; i++) {
            char originalChar = original.charAt(i);
            char typedChar = typed.charAt(i);

            if (originalChar == typedChar) {
                matchCount++;
            } else if (firstMismatchPos == -1) {
                firstMismatchPos = i + 1;
                origCharMismatch = originalChar;
                typedCharMismatch = typedChar;
            }
        }

        double accuracyPercentage = ((double) matchCount / totalLength) * 100.0;

        if (firstMismatchPos == -1) {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | No Mismatches%n",
                    matchCount, totalLength, accuracyPercentage);
        } else {
            System.out.printf(Locale.US, "Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')%n",
                    matchCount, totalLength, accuracyPercentage, firstMismatchPos, origCharMismatch, typedCharMismatch);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 2: Typing Speed Test Accuracy Checker ---");

        // Sample Case 1
        String orig1 = "hello world";
        String typed1 = "hello worlt";
        System.out.print("Input: original=\"" + orig1 + "\", typed=\"" + typed1 + "\" -> ");
        checkTypingAccuracy(orig1, typed1);

        // Sample Case 2
        String orig2 = "coding";
        String typed2 = "coding";
        System.out.print("Input: original=\"" + orig2 + "\", typed=\"" + typed2 + "\" -> ");
        checkTypingAccuracy(orig2, typed2);

        // Exception Handling Demonstration
        try {
            checkTypingAccuracy("java", "javascript");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}
