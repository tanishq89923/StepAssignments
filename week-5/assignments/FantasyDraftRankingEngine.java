import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 5 - S5 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 5 (Advanced): Fantasy League Auto-Draft Ranking Engine
 */
public class FantasyDraftRankingEngine {

    /**
     * Player class encapsulating player details and implementing Comparable<Player>
     * to enable automatic sorting via Arrays.sort.
     */
    public static class Player implements Comparable<Player> {
        private final String name;
        private final int matchesPlayed;
        private final double battingAverage;
        private final boolean injured;

        /**
         * Default constructor demonstrating this() constructor chaining.
         */
        public Player() {
            this("Unknown", 0, 0.0, false);
        }

        /**
         * Parameterized constructor demonstrating this keyword usage and field encapsulation.
         */
        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Player name cannot be null or empty.");
            }
            if (matchesPlayed < 0) {
                throw new IllegalArgumentException("Matches played cannot be negative.");
            }
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public String getName() {
            return name;
        }

        public int getMatchesPlayed() {
            return matchesPlayed;
        }

        public double getBattingAverage() {
            return battingAverage;
        }

        public boolean isInjured() {
            return injured;
        }

        /**
         * Compares this player with another for ranking.
         * Ranks players by battingAverage descending.
         */
        @Override
        public int compareTo(Player other) {
            if (other == null) {
                return -1;
            }
            // Descending order of batting average
            int avgCompare = Double.compare(other.battingAverage, this.battingAverage);
            if (avgCompare != 0) {
                return avgCompare;
            }
            // Tie-break by matches played descending
            return Integer.compare(other.matchesPlayed, this.matchesPlayed);
        }

        @Override
        public boolean equals(Object obj) {
            // Demonstrates instanceof type checking
            if (this == obj) return true;
            if (!(obj instanceof Player)) return false;
            Player other = (Player) obj;
            return this.matchesPlayed == other.matchesPlayed &&
                   Double.compare(this.battingAverage, other.battingAverage) == 0 &&
                   this.injured == other.injured &&
                   this.name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }

        @Override
        public String toString() {
            return name + " (" + battingAverage + ")";
        }
    }

    /**
     * Overloaded Rule 1: Experience-only rule for established players.
     * Qualifies if matchesPlayed >= 10 regardless of injury status.
     *
     * @param matchesPlayed Total matches played by the player
     * @return true if draftable under experience rule
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded Rule 2: Combined matches-and-fitness rule for other players.
     * Qualifies if matchesPlayed >= 5 AND player is currently NOT injured.
     *
     * @param matchesPlayed Total matches played by the player
     * @param injured       Current injury status of the player
     * @return true if draftable under combined rule
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Evaluates a list of candidate players, filters out those who are not draftable,
     * ranks draftable players using Arrays.sort, and returns the formatted leaderboard.
     *
     * @param players Array of candidate players
     * @return Formatted ranking string "1. Name | 2. Name | ..."
     */
    public static String draftAndRank(Player[] players) {
        if (players == null || players.length == 0) {
            return "No draftable players.";
        }

        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            if (p == null) continue;

            // Check experience rule first, then combined rule
            boolean qualifies = isDraftable(p.getMatchesPlayed()) ||
                                isDraftable(p.getMatchesPlayed(), p.isInjured());

            if (qualifies) {
                draftableList.add(p);
            }
        }

        if (draftableList.isEmpty()) {
            return "No draftable players.";
        }

        // Convert to array and rank using standard library Arrays.sort (utilizing Comparable)
        Player[] draftableArray = draftableList.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        // Build formatted display string
        StringBuilder rankingBuilder = new StringBuilder();
        for (int rank = 0; rank < draftableArray.length; rank++) {
            rankingBuilder.append(rank + 1).append(". ").append(draftableArray[rank].getName());
            if (rank < draftableArray.length - 1) {
                rankingBuilder.append(" | ");
            }
        }

        return rankingBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 5: Fantasy League Auto-Draft Ranking Engine ---");

        Player[] squad = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println("Candidate Players:");
        for (Player p : squad) {
            System.out.println(" - " + p.getName() + ": Matches=" + p.getMatchesPlayed() +
                               ", Avg=" + p.getBattingAverage() + ", Injured=" + p.isInjured());
        }

        String rankedBoard = draftAndRank(squad);
        System.out.println("\nDraft & Rank Result:\n" + rankedBoard);
    }
}
