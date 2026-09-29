/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 2 - S2 - Assignments Problem (HW)
 * Problem 4: Library ISBN Normalizer & Validator
 */
public class LibraryIsbnValidator {

    /**
     * Normalizes the raw ISBN-style code: trims whitespace and converts the
     * first 3 characters to uppercase while leaving the rest unchanged.
     *
     * @param raw Raw input code string
     * @return Normalized code string
     */
    public static String normalizeCode(String raw) {
        if (raw == null) {
            return "";
        }
        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    /**
     * Validates the normalized code against ISBN requirements:
     * - Exactly 13 characters
     * - First 3 characters are letters
     * - Remaining 10 characters are digits (checked using Character.isLetter/isDigit without regex)
     * Builds formatted display using StringBuilder if valid, or prints specific reason if invalid.
     *
     * @param code Normalized code string
     * @return Formatted display string or error message
     */
    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Validate first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Validate remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body (year and catalog must be digits)";
            }
        }

        // Build formatted line: "[PUBCODE] YEAR: 20XX | CATALOG: 123456"
        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder formattedLine = new StringBuilder();
        formattedLine.append("[").append(pubCode).append("] ")
                     .append("YEAR: ").append(year).append(" | ")
                     .append("CATALOG: ").append(catalog);

        return formattedLine.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: Library ISBN Normalizer & Validator ---");

        // Sample Case 1
        String raw1 = " pen2026004251 ";
        String norm1 = normalizeCode(raw1);
        System.out.println("Input: \"" + raw1 + "\"");
        System.out.println("Normalized: \"" + norm1 + "\" -> " + validateAndFormat(norm1));

        // Sample Case 2
        String raw2 = "12N2026004251";
        String norm2 = normalizeCode(raw2);
        System.out.println("\nInput: \"" + raw2 + "\"");
        System.out.println("Normalized: \"" + norm2 + "\" -> " + validateAndFormat(norm2));

        // Additional Cases
        String raw3 = "oxf202412345A";
        String norm3 = normalizeCode(raw3);
        System.out.println("\nInput: \"" + raw3 + "\"");
        System.out.println("Normalized: \"" + norm3 + "\" -> " + validateAndFormat(norm3));

        String raw4 = "short";
        String norm4 = normalizeCode(raw4);
        System.out.println("\nInput: \"" + raw4 + "\"");
        System.out.println("Normalized: \"" + norm4 + "\" -> " + validateAndFormat(norm4));
    }
}