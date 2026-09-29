/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 1 - S1 - Assignments Problem (HW)
 * Problem 1: The Exam Hall Seat Duplication Checker
 */

public class ExamHallSeatDuplicationChecker {

    /**
     * Scans the array of assigned seat numbers and flags any duplicates
     * using only loops and arrays without any Java Collections classes.
     *
     * @param seatNumbers Array of seat numbers assigned to students
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        if (seatNumbers == null) {
            throw new IllegalArgumentException("Error: Seat numbers array cannot be null.");
        }
        if (seatNumbers.length == 0) {
            System.out.println("No seats allocated to check.");
            return;
        }

        boolean duplicateFound = false;
        int totalSeats = seatNumbers.length;

        for (int i = 0; i < totalSeats; i++) {
            boolean alreadyReported = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyReported = true;
                    break;
                }
            }
            if (alreadyReported) {
                continue;
            }

            for (int j = i + 1; j < totalSeats; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: Exam Hall Seat Duplication Checker ---");
        
        // Sample Case 1
        int[] hallSample1 = {101, 102, 103, 102, 105};
        System.out.print("Input: {101, 102, 103, 102, 105} -> ");
        checkDuplicateSeats(hallSample1);

        // Sample Case 2
        int[] hallSample2 = {101, 102, 103, 104, 105};
        System.out.print("Input: {101, 102, 103, 104, 105} -> ");
        checkDuplicateSeats(hallSample2);

        // Exception Handling Demonstration
        try {
            checkDuplicateSeats(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}