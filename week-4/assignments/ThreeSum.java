import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Student Name: Rehaan Ajani
 * Registration Number: RA2511026010673
 * College: SRM Institute of Science and Technology, Kattankulathur (SRM KTR)
 * Section: AK1, B.Tech CSE with specialization in AI & ML
 * 
 * Week 4 - S4 - Programming Fundamental - Assignment Problem (HW)
 * Category C - Problem A3: 3Sum
 */
public class ThreeSum {

    /**
     * Finds all unique triplets in the array which sum to zero.
     * Uses sorting followed by a two-pointer approach with systematic duplicate avoidance.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) beyond output list
     *
     * @param nums Input integer array
     * @return 2D array representing unique triplets [a, b, c] such that a + b + c = 0
     */
    public static int[][] threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new int[0][0];
        }

        Arrays.sort(nums);
        List<int[]> resultList = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Early termination: if smallest element is > 0, sum cannot be 0
            if (nums[i] > 0) {
                break;
            }

            // Avoid duplicate triplets by skipping identical first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int targetSum = -nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int pairSum = nums[left] + nums[right];

                if (pairSum == targetSum) {
                    resultList.add(new int[]{nums[i], nums[left], nums[right]});

                    // Skip duplicate left values
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicate right values
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (pairSum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("--- Problem A3: 3Sum ---");

        // Sample Case 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        int[][] res1 = threeSum(nums1);
        System.out.println("Input: nums = " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.deepToString(res1));

        // Sample Case 2 (all zeroes)
        int[] nums2 = {0, 0, 0};
        int[][] res2 = threeSum(nums2);
        System.out.println("\nInput: nums = " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.deepToString(res2));

        // Additional Case
        int[] nums3 = {-2, 0, 1, 1, 2};
        int[][] res3 = threeSum(nums3);
        System.out.println("\nInput: nums = " + Arrays.toString(nums3));
        System.out.println("Output: " + Arrays.deepToString(res3));
    }
}