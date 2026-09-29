import java.util.Arrays;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 5 - S5 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 3 (Intermediate): Top Performer Tracker
 */
public class TopPerformerTracker {

    /**
     * Finds the minimum score, maximum score, and the spread (max - min)
     * in a single pass without sorting the array.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param scores Array of weekly fantasy scores
     * @return Formatted summary string "Min: ... | Max: ... | Spread: ..."
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length < 2) {
            throw new IllegalArgumentException("Error: Scores array must have at least 2 entries.");
        }

        int minScore = scores[0];
        int maxScore = scores[0];

        // Single pass linear scan
        for (int i = 1; i < scores.length; i++) {
            int currentScore = scores[i];
            if (currentScore < minScore) {
                minScore = currentScore;
            }
            if (currentScore > maxScore) {
                maxScore = currentScore;
            }
        }

        int spread = maxScore - minScore;

        return "Min: " + minScore + " | Max: " + maxScore + " | Spread: " + spread;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: Top Performer Tracker ---");

        // Sample Case
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println("Input Scores: " + Arrays.toString(scores));
        System.out.println("Output: " + findMinMaxSpread(scores));

        // Additional Case
        int[] scores2 = {120, 15, 85, 40};
        System.out.println("\nInput Scores: " + Arrays.toString(scores2));
        System.out.println("Output: " + findMinMaxSpread(scores2));

        // Exception Handling Demonstration
        try {
            findMinMaxSpread(new int[]{50});
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}