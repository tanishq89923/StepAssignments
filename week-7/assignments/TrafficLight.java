/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 7 - S7 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 4: The Traffic Light
 */
public class TrafficLight {

    private static final String[] SEQUENCE = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int stateIndex; // 0: RED, 1: GREEN, 2: YELLOW

    /**
     * Initializes traffic light with a fixed ID, starting on RED.
     *
     * @param id Unique identifier for the traffic light
     */
    public TrafficLight(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: TrafficLight ID cannot be null or empty.");
        }
        this.id = id;
        this.stateIndex = 0; // Starts on RED
    }

    public String getId() {
        return id;
    }

    /**
     * Read-only getter for current signal color.
     *
     * @return Current active color (RED, GREEN, or YELLOW)
     */
    public String getColor() {
        return SEQUENCE[this.stateIndex];
    }

    /**
     * Moves light strictly forward through the sequence:
     * RED -> GREEN -> YELLOW -> RED.
     *
     * @return The new color after advancing
     */
    public String next() {
        this.stateIndex = (this.stateIndex + 1) % SEQUENCE.length;
        return getColor();
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: The Traffic Light ---");

        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("Light ID: " + t.getId());
        System.out.println("t.getColor() -> \"" + t.getColor() + "\"");
        System.out.println("t.next()     -> \"" + t.next() + "\"");
        System.out.println("t.next()     -> \"" + t.next() + "\"");
        System.out.println("t.next()     -> \"" + t.next() + "\"");
        System.out.println("t.next()     -> \"" + t.next() + "\"");
    }
}
