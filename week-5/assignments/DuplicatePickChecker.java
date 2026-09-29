import java.util.Arrays;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 5 - S5 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 2 (Easy): Duplicate Player Pick Checker
 */
public class DuplicatePickChecker {

    /**
     * Checks if a submitted lineup contains any duplicated player name
     * using nested loops without any Java Collections classes.
     *
     * @param playerNames Array of player names in the lineup
     * @return Result message indicating the first duplicate found or confirmation of none
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null || playerNames.length == 0) {
            return "No Duplicates Found";
        }

        int lineupLength = playerNames.length;

        // Pairwise comparison using nested loops
        for (int i = 0; i < lineupLength; i++) {
            if (playerNames[i] == null) {
                continue;
            }
            for (int j = i + 1; j < lineupLength; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 2: Duplicate Player Pick Checker ---");

        // Sample Case 1 (Duplicate present)
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Input: " + Arrays.toString(lineup1));
        System.out.println("Result: " + findDuplicatePick(lineup1));

        // Sample Case 2 (No duplicates)
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("\nInput: " + Arrays.toString(lineup2));
        System.out.println("Result: " + findDuplicatePick(lineup2));

        // Edge case: null lineup
        System.out.println("\nInput: null");
        System.out.println("Result: " + findDuplicatePick(null));
    }
}
