import java.util.Arrays;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 5 - S5 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 4 (Intermediate): Match Day Grid Analyzer
 */
public class MatchDayGridAnalyzer {

    /**
     * Helper method that computes the average runs per over for a single match.
     * Reused by the classifier method for each row.
     *
     * @param row Runs scored in each over of a match
     * @return Average runs scored per over
     */
    public static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        return (double) sum / row.length;
    }

    /**
     * Classifies each match as "Power Surge" (average >= threshold) or "Normal",
     * reusing the rowAverage helper method for each row.
     *
     * @param runsPerOver 2D array of runs per over (one row per match)
     * @param threshold   Scoring rate threshold
     * @return Formatted summary string for all matches
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "No match data available.";
        }

        StringBuilder classificationBuilder = new StringBuilder();

        for (int matchIndex = 0; matchIndex < runsPerOver.length; matchIndex++) {
            double average = rowAverage(runsPerOver[matchIndex]);
            String status = (average >= threshold) ? "Power Surge" : "Normal";

            classificationBuilder.append("Match ").append(matchIndex).append(": ").append(status);

            if (matchIndex < runsPerOver.length - 1) {
                classificationBuilder.append(" | ");
            }
        }

        return classificationBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: Match Day Grid Analyzer ---");

        // Sample Case
        int[][] runsGrid = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        int threshold = 8;

        System.out.println("Match Runs Grid: " + Arrays.deepToString(runsGrid));
        System.out.println("Threshold: " + threshold);
        System.out.println("Result: " + classifyMatches(runsGrid, threshold));

        // Jagged Array Case (matches with different number of overs)
        int[][] jaggedGrid = {
            {12, 10, 8, 14},
            {5, 6},
            {9, 9, 9}
        };
        System.out.println("\nJagged Runs Grid: " + Arrays.deepToString(jaggedGrid));
        System.out.println("Result: " + classifyMatches(jaggedGrid, threshold));
    }
}
