/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 7 - S7 - OOP Fundamental - Assignment Practice Problem (HW)
 * Category C - Problem 1: The Health Bar
 */
public class GameCharacter {

    private final int maxHealth;
    private int health;

    /**
     * Constructs a Character with fixed maxHealth.
     * Starts at full health.
     *
     * @param maxHealth Maximum health capacity of character
     */
    public GameCharacter(int maxHealth) {
        if (maxHealth <= 0) {
            throw new IllegalArgumentException("Error: Maximum health must be greater than 0.");
        }
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    /**
     * Applies damage to character. Health is floored at 0.
     *
     * @param amount Damage to inflict
     */
    public void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid damage amount: Must be greater than 0.");
            return;
        }
        this.health = Math.max(0, this.health - amount);
        System.out.println("takeDamage(" + amount + ") -> health = " + this.health + (this.health == 0 ? " (floored)" : ""));
    }

    /**
     * Heals character. Health is capped at maxHealth.
     *
     * @param amount Healing to restore
     */
    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Invalid healing amount: Must be greater than 0.");
            return;
        }
        this.health = Math.min(this.maxHealth, this.health + amount);
        System.out.println("heal(" + amount + ") -> health = " + this.health + (this.health == this.maxHealth ? " (capped)" : ""));
    }

    /**
     * Read-only getter for current health. No direct setter exists.
     *
     * @return Current health value
     */
    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 1: The Health Bar ---");

        GameCharacter c = new GameCharacter(100);
        System.out.println("Initial Health: " + c.getHealth() + "/" + c.getMaxHealth());

        c.takeDamage(30);
        c.heal(50);
        c.takeDamage(150);

        System.out.println("Final Health: " + c.getHealth());
    }
}
