import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 2 - S2 - Assignments Problem (HW)
 * Problem 5: Stop-Word-Filtered Word Frequency Report
 */
public class StopWordFrequencyReport {

    private static final String[] STOP_WORDS = {"the", "was", "and", "a", "is", "of", "in"};

    /**
     * Checks if a word is in the fixed stop-word list.
     *
     * @param word Word to check
     * @return true if word is a stop-word, false otherwise
     */
    private static boolean isStopWord(String word) {
        for (String stopWord : STOP_WORDS) {
            if (stopWord.equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Analyzes feedback text by stripping punctuation, removing common stop words,
     * counting frequencies with a HashMap, and printing the results sorted descending by frequency.
     *
     * @param feedback Paragraph of feedback text
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            System.out.println("No feedback content to analyze.");
            return;
        }

        // Normalize: convert to lowercase, strip punctuation using replace()
        String cleanedText = feedback.toLowerCase()
                .replace(".", "")
                .replace(",", "")
                .replace("!", "")
                .replace("?", "")
                .replace(";", "")
                .replace(":", "")
                .replace("\"", "")
                .trim();

        String[] words = cleanedText.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (isStopWord(word)) {
                continue;
            }
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency in descending order
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        Collections.sort(entryList, (a, b) -> {
            int freqCompare = b.getValue().compareTo(a.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
            return a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: Stop-Word-Filtered Word Frequency Report ---");

        String feedbackSample = "The mentor was great, the session was great and clear.";
        System.out.println("Input Paragraph:\n\"" + feedbackSample + "\"\n");
        System.out.println("Filtered Word Frequency Report:");
        printFilteredWordFrequency(feedbackSample);
    }
}