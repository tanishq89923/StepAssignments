import java.util.Arrays;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 5 - S5 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 1 (Easy): Fantasy Team Score Multiplier
 */
public class FantasyScoreMultiplier {

    private static final double CAPTAIN_MULTIPLIER = 2.0;
    private static final double VICE_CAPTAIN_MULTIPLIER = 1.5;

    /**
     * Applies captain (2.0x) and vice-captain (1.5x) point multipliers directly
     * to the playerScores array in place.
     *
     * @param playerScores      Array of player scores (modified directly by reference)
     * @param captainIndex      Index of the chosen captain
     * @param viceCaptainIndex  Index of the chosen vice-captain
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            throw new IllegalArgumentException("Error: Player scores array cannot be null.");
        }

        if (captainIndex < 0 || captainIndex >= playerScores.length) {
            throw new IndexOutOfBoundsException("Error: Captain index out of bounds: " + captainIndex);
        }

        if (viceCaptainIndex < 0 || viceCaptainIndex >= playerScores.length) {
            throw new IndexOutOfBoundsException("Error: Vice-Captain index out of bounds: " + viceCaptainIndex);
        }

        if (captainIndex == viceCaptainIndex) {
            throw new IllegalArgumentException("Error: Captain and Vice-Captain cannot be the same player.");
        }

        // Direct in-place modification
        playerScores[captainIndex] = playerScores[captainIndex] * CAPTAIN_MULTIPLIER;
        playerScores[viceCaptainIndex] = playerScores[viceCaptainIndex] * VICE_CAPTAIN_MULTIPLIER;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: Fantasy Team Score Multiplier ---");

        // Example Case
        double[] scores = {40, 55, 30, 62};
        System.out.println("Before Multipliers: " + Arrays.toString(scores));
        
        applyMultipliers(scores, 1, 3);
        System.out.println("After Multipliers:  " + Arrays.toString(scores));

        // Exception Handling Demonstration
        try {
            applyMultipliers(scores, 0, 10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}