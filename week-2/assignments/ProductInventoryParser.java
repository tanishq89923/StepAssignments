/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 2 - S2 - Assignments Problem (HW)
 * Problem 3: Product Inventory CSV Parser
 */
public class ProductInventoryParser {

    /**
     * Parses a CSV inventory record in the form "ProductName,SKU,Quantity"
     * and prints a formatted record, or "Invalid Record" if format is incorrect.
     *
     * @param csvLine Single CSV line containing inventory data
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields are present
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String productName = fields[0].trim();
        String sku = fields[1].trim();
        String quantity = fields[2].trim();

        if (productName.isEmpty() || sku.isEmpty() || quantity.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + productName + " | SKU: " + sku + " | Qty: " + quantity);
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 3: Product Inventory CSV Parser ---");

        // Sample Test Cases
        String record1 = "Wireless Mouse,WM-2201,150";
        System.out.print("Input: \"" + record1 + "\" -> ");
        parseInventoryRecord(record1);

        String record2 = "Wireless Mouse,150";
        System.out.print("Input: \"" + record2 + "\" -> ");
        parseInventoryRecord(record2);

        String record3 = "Mechanical Keyboard,KB-902,45";
        System.out.print("Input: \"" + record3 + "\" -> ");
        parseInventoryRecord(record3);

        String record4 = null;
        System.out.print("Input: null -> ");
        parseInventoryRecord(record4);
    }
}