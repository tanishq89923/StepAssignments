import java.util.Arrays;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 4 - S4 - Programming Fundamental - Assignment Problem (HW)
 * Category C - Problem A5: Find Minimum in Rotated Sorted Array
 */
public class FindMinRotatedSortedArray {

    /**
     * Finds the minimum element in a rotated sorted array of unique elements.
     * Uses modified binary search comparing mid to right pointer.
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param nums Rotated sorted integer array with distinct elements
     * @return The minimum element in the array
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Error: Array cannot be null or empty.");
        }

        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // If middle element is greater than rightmost element,
            // the inflection point (minimum) must be in the right half
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                // Minimum lies in the left half including mid
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println("--- Problem A5: Find Minimum in Rotated Sorted Array ---");

        // Sample Case 1
        int[] nums1 = {3, 4, 5, 1, 2};
        int min1 = findMin(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + " -> Min: " + min1);

        // Sample Case 2
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int min2 = findMin(nums2);
        System.out.println("Input: nums = " + Arrays.toString(nums2) + " -> Min: " + min2);

        // Sample Case 3 (no rotation)
        int[] nums3 = {11, 13, 15, 17};
        int min3 = findMin(nums3);
        System.out.println("Input: nums = " + Arrays.toString(nums3) + " -> Min: " + min3);

        // Exception Handling Demonstration
        try {
            findMin(null);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}