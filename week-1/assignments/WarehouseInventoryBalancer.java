/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 1 - S1 - Assignments Problem (HW)
 * Problem 4: The Warehouse Inventory Balancer
 */
public class WarehouseInventoryBalancer {

    /**
     * Analyzes inventory in Section A and Section B:
     * computes section totals, checks balance status, and identifies
     * the highest quantity item with its location.
     *
     * @param sectionA Item quantities in Section A
     * @param sectionB Item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null) {
            throw new IllegalArgumentException("Error: Section inventory arrays cannot be null.");
        }

        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("Error: Sections must have the same number of product categories. " +
                    "Section A size: " + sectionA.length + ", Section B size: " + sectionB.length);
        }

        if (sectionA.length == 0) {
            System.out.println("Inventory is empty.");
            return;
        }

        int totalA = 0;
        int totalB = 0;

        int highestQuantity = Integer.MIN_VALUE;
        String highestSection = "Section A";
        int highestItemNumber = 1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemNumber = i + 1;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemNumber = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA +
                " | Section B Total: " + totalB +
                " | Status: " + status +
                " | Highest Quantity: " + highestQuantity +
                " (" + highestSection + ", Item " + highestItemNumber + ")");
    }

    public static void main(String[] args) {
        System.out.println("--- Problem 4: Warehouse Inventory Balancer ---");

        // Sample Case 1
        int[] secA1 = {20, 15, 30};
        int[] secB1 = {25, 10, 30};
        System.out.println("Input: sectionA={20,15,30}, sectionB={25,10,30}");
        analyzeInventory(secA1, secB1);

        // Case 2: Unbalanced
        int[] secA2 = {50, 10, 20};
        int[] secB2 = {30, 15, 25};
        System.out.println("\nInput: sectionA={50,10,20}, sectionB={30,15,25}");
        analyzeInventory(secA2, secB2);

        // Exception Handling Demonstration
        try {
            analyzeInventory(new int[]{10, 20}, new int[]{10});
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}