import java.util.Arrays;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 4 - S4 - Programming Fundamental - Assignment Problem (HW)
 * Category C - Problem A1: Product of Array Except Self
 */
public class ProductExceptSelf {

    /**
     * Computes an array where answer[i] is the product of every element in nums
     * except nums[i], without using the division operator.
     * Time Complexity: O(n) using prefix and suffix passes.
     * Space Complexity: O(1) auxiliary space (output array does not count).
     *
     * @param nums Input array of numbers
     * @return Array containing product except self for each index
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Error: Input array cannot be null.");
        }
        if (nums.length < 2) {
            throw new IllegalArgumentException("Error: Array must contain at least 2 elements.");
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: Forward pass to compute running prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: Backward pass to accumulate running suffix products
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem A1: Product of Array Except Self ---");

        // Sample Case 1
        int[] nums1 = {1, 2, 3, 4};
        int[] res1 = productExceptSelf(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(res1));

        // Sample Case 2 (with zero)
        int[] nums2 = {-1, 1, 0, -3, 3};
        int[] res2 = productExceptSelf(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(res2));

        // Exception Handling Demonstration
        try {
            productExceptSelf(new int[]{5});
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}
