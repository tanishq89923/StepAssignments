import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 4 - S4 - Programming Fundamental - Assignment Problem (HW)
 * Category C - Problem A4: Subarray Sum Equals K
 */
public class SubarraySumK {

    /**
     * Returns total number of continuous subarrays whose sum equals k.
     * Uses prefix sums and HashMap frequency counting to handle both positive and negative values.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums Array of integers (may include negative numbers)
     * @param k    Target subarray sum
     * @return Count of contiguous subarrays summing to k
     */
    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Map stores: prefixSum -> frequency of occurrence
        Map<Integer, Integer> prefixSumFrequencies = new HashMap<>();

        // Base case: an empty prefix sum is 0 occurring once
        prefixSumFrequencies.put(0, 1);

        int runningSum = 0;
        int matchingSubarraysCount = 0;

        for (int num : nums) {
            runningSum += num;

            // If (runningSum - k) exists in prefix map, then a subarray summing to k exists
            int requiredPrefix = runningSum - k;
            if (prefixSumFrequencies.containsKey(requiredPrefix)) {
                matchingSubarraysCount += prefixSumFrequencies.get(requiredPrefix);
            }

            prefixSumFrequencies.put(runningSum, prefixSumFrequencies.getOrDefault(runningSum, 0) + 1);
        }

        return matchingSubarraysCount;
    }

    public static void main(String[] args) {
        System.out.println("--- Problem A4: Subarray Sum Equals K ---");

        // Sample Case 1
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        int count1 = subarraySum(nums1, k1);
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Subarrays Count: " + count1);

        // Sample Case 2
        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        int count2 = subarraySum(nums2, k2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Subarrays Count: " + count2);

        // Additional Case
        int[] nums3 = {3, 4, 7, 2, -3, 1, 4, 2};
        int k3 = 7;
        int count3 = subarraySum(nums3, k3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3) + ", k = " + k3);
        System.out.println("Subarrays Count: " + count3);
    }
}