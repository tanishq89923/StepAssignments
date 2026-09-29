/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 6 - S6 - Classes and Objects Revision - Assignment Practice Problem (HW)
 * Category C - Problem M1: Library Inventory Management
 */
public class BookInventory {

    private String title;
    private String author;
    private int copiesAvailable;

    /**
     * Parameterized constructor setting title, author, and available copies.
     *
     * @param title           Title of the book
     * @param author          Author of the book
     * @param copiesAvailable Number of copies currently available in library
     */
    public BookInventory(String title, String author, int copiesAvailable) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Title cannot be null or empty.");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Error: Author cannot be null or empty.");
        }
        if (copiesAvailable < 0) {
            throw new IllegalArgumentException("Error: Available copies cannot be negative.");
        }
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    /**
     * Prints one formatted inventory entry line.
     */
    public void printEntry() {
        System.out.println(title + " by " + author + " - " + copiesAvailable + " copies available");
    }

    public static void main(String[] args) {
        System.out.println("--- Problem M1: Library Inventory Management ---");

        // Storing 4 BookInventory objects in an array
        BookInventory[] library = {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        // Processing array using a loop
        for (BookInventory book : library) {
            book.printEntry();
        }
    }
}