/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 6 - S6 - Classes and Objects Revision - Assignment Practice Problem (HW)
 * Category C - Problem M4: Exam Hall Ticket Reference Management
 */
public class HallTicketReference {

    public static class HallTicket {
        public String studentName;
        public int seatNumber;

        public HallTicket(String studentName, int seatNumber) {
            this.studentName = studentName;
            this.seatNumber = seatNumber;
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Problem M4: Exam Hall Ticket Reference Management ---");

        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya; // Points to the exact same object reference

        copy.seatNumber = 45; // Modifying through reference copy

        HallTicket separate = new HallTicket("Priya", 45); // Brand new distinct object

        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));
    }
}
