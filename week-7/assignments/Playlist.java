import java.util.Arrays;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 7 - S7 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 2: The Playlist
 */
public class Playlist {

    private final String[] songs;
    private int songCount;

    /**
     * Constructs a Playlist with fixed maximum capacity.
     *
     * @param capacity Maximum songs playlist can hold
     */
    public Playlist(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Error: Capacity must be greater than 0.");
        }
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    /**
     * Adds a song title to the playlist.
     *
     * @param title Song title to add
     */
    public void addSong(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Invalid song: Title cannot be null or empty.");
            return;
        }
        if (songCount >= songs.length) {
            System.out.println("Playlist is full. Cannot add \"" + title + "\".");
            return;
        }
        songs[songCount] = title.trim();
        songCount++;
    }

    /**
     * Returns a defensive copy of all songs added so far.
     * Modifying the returned array has zero effect on playlist contents.
     *
     * @return Safe copy of song titles array
     */
    public String[] getSongs() {
        String[] safeCopy = new String[songCount];
        System.arraycopy(songs, 0, safeCopy, 0, songCount);
        return safeCopy;
    }

    /**
     * Read-only count of how many songs are in the playlist.
     *
     * @return Number of songs currently added
     */
    public int getSongCount() {
        return this.songCount;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 2: The Playlist ---");

        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        System.out.println("Current Song Count: " + p.getSongCount());
        System.out.println("Songs in Playlist: " + Arrays.toString(p.getSongs()));

        // Defensive Copy Test: Attempting external modification
        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("\nAfter modifying returned copy[0] to \"Hacked\":");
        System.out.println("copy[0] = \"" + copy[0] + "\"");
        System.out.println("p.getSongs()[0] is still \"" + p.getSongs()[0] + "\" (Protected by defensive copy)");
    }
}
