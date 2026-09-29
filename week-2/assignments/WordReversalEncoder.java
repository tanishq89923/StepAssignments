/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 2 - S2 - Assignments Problem (HW)
 * Problem 2: Word Reversal Encoder
 */
public class WordReversalEncoder {

    /**
     * Reverses each word in a sentence individually while maintaining the original word order.
     *
     * @param sentence Space-separated words sentence
     * @return Encoded sentence with each word reversed
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Error: Sentence cannot be null.");
        }

        if (sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split(" ");
        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder reversedWord = new StringBuilder();

            // Reverse using a loop as specified
            for (int j = word.length() - 1; j >= 0; j--) {
                reversedWord.append(word.charAt(j));
            }

            resultBuilder.append(reversedWord);
            if (i < words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 2: Word Reversal Encoder ---");

        // Sample Test Case
        String sampleSentence = "hello club";
        String encoded = reverseEachWord(sampleSentence);
        System.out.println("Input: \"" + sampleSentence + "\" -> Output: " + encoded);

        // Additional Test Case
        String test2 = "Java Programming Language";
        System.out.println("Input: \"" + test2 + "\" -> Output: " + reverseEachWord(test2));

        // Exception Handling Demonstration
        try {
            reverseEachWord(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }
    }
}
