import java.util.Arrays;

/**
 * Student Name: Tanishq kumar
 * Registration Number: RA2511026010704
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AL1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 4 - S4 - Programming Fundamental - Assignment Problem (HW)
 * Category C - Problem A2: Maximum Subarray
 */
public class MaxSubarray {

    /**
     * Solves the Maximum Subarray problem using Kadane's algorithm.
     * At each position, decides whether to extend the current running subarray
     * or restart from the current element.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums Input array (may contain positive and negative numbers)
     * @return The maximum sum of any contiguous subarray
     */
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Error: Input array cannot be null or empty.");
        }

        int currentSubarraySum = nums[0];
        int maxSubarraySum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to extend current subarray or start fresh from nums[i]
            currentSubarraySum = Math.max(nums[i], currentSubarraySum + nums[i]);
            maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
        }

        return maxSubarraySum;
    }

    /**
     * Alternative Divide-and-Conquer solution with O(n log n) time complexity.
     * Provided as follow-up discussion as noted in requirements.
     */
    public static int maxSubArrayDivideAndConquer(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;
        int leftMax = maxSubArrayDivideAndConquer(nums, left, mid);
        int rightMax = maxSubArrayDivideAndConquer(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = mid; i >= left; i--) {
            currentSum += nums[i];
            if (currentSum > leftSum) {
                leftSum = currentSum;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        currentSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentSum += nums[i];
            if (currentSum > rightSum) {
                rightSum = currentSum;
            }
        }

        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem A2: Maximum Subarray ---");

        // Sample Case 1
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum1 = maxSubArray(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Max Subarray Sum (Kadane's O(n)): " + sum1);

        // Sample Case 2 (all negative)
        int[] nums2 = {-3, -1, -2};
        int sum2 = maxSubArray(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Max Subarray Sum (Kadane's O(n)): " + sum2);

        // Divide and Conquer Verification
        int dncSum = maxSubArrayDivideAndConquer(nums1, 0, nums1.length - 1);
        System.out.println("\nDivide & Conquer O(n log n) Verification for Case 1: " + dncSum);

        // Exception Handling Demonstration
        try {
            maxSubArray(null);
        } catch (IllegalArgumentException e) {
            System.out.println("\nCaught Expected Exception: " + e.getMessage());
        }
    }
}
