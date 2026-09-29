/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 1 - S1 - Assignments Problem (HW)
 * Problem 5: The Movie Review Word Length Profiler
 */
public class MovieReviewWordLengthProfiler {

    /**
     * Splits a movie review into words, categorizes each word
     * into Short (1-4), Medium (5-8), and Long (9+) based on letter length,
     * and prints the summary breakdown.
     *
     * @param review Movie review text
     */
    public static void classifyWordLengths(String review) {
        if (review == null) {
            throw new IllegalArgumentException("Error: Review text cannot be null.");
        }

        String trimmedReview = review.trim();
        if (trimmedReview.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        String[] rawWords = trimmedReview.split("\\s+");

        int shortCount = 0;   // 1 to 4 letters
        int mediumCount = 0;  // 5 to 8 letters
        int longCount = 0;    // 9+ letters

        for (String rawWord : rawWords) {
            String cleanedWord = rawWord.replaceAll("^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");
            int wordLength = cleanedWord.length();

            if (wordLength >= 1 && wordLength <= 4) {
                shortCount++;
            } else if (wordLength >= 5 && wordLength <= 8) {
                mediumCount++;
            } else if (wordLength >= 9) {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: Movie Review Word Length Profiler ---");

        // Sample Case 1
        String sampleReview = "This movie was absolutely fantastic and thrilling";
        System.out.println("Input: \"" + sampleReview + "\"");
        System.out.print("Output: ");
        classifyWordLengths(sampleReview);

        // Case 2 with punctuation
        String punctuatedReview = "An incredible, breathtaking cinema experience!";
        System.out.println("\nInput: \"" + punctuatedReview + "\"");
        System.out.print("Output: ");
        classifyWordLengths(punctuatedReview);

        // Exception Handling Demonstration
        try {
            classifyWordLengths(null);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}
