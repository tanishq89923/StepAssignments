/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 1 - S1 - Assignments Problem (HW)
 * Problem 3: The Traffic Signal Streak Analyzer
 */
public class TrafficSignalStreakAnalyzer {

    /**
     * Scans through the traffic signal log and finds the longest continuous streak
     * of consecutive identical signal colors.
     *
     * @param signalLog String representing sequence of signal readings (e.g. "RRGGGYRR")
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null) {
            throw new IllegalArgumentException("Error: Signal log cannot be null.");
        }

        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty. No streaks found.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int maxStreakLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentColor) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestColor = currentColor;
                }
                currentColor = ch;
                currentStreakLength = 1;
            }
        }

        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            longestColor = currentColor;
        }

        System.out.println("Longest Streak: '" + longestColor + "' repeated " + maxStreakLength + " times");
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: Traffic Signal Streak Analyzer ---");

        // Sample Case 1
        String log1 = "RRGGGYRR";
        System.out.print("Input: \"" + log1 + "\" -> ");
        findLongestStreak(log1);

        // Sample Case 2
        String log2 = "RRRRYYGG";
        System.out.print("Input: \"" + log2 + "\" -> ");
        findLongestStreak(log2);

        // Additional Case
        String log3 = "RGBY";
        System.out.print("Input: \"" + log3 + "\" -> ");
        findLongestStreak(log3);

        // Exception Handling Demonstration
        try {
            findLongestStreak(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}