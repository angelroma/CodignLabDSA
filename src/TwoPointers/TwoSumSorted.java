package TwoPointers;

import java.util.Arrays;

public class TwoSumSorted {
    /**
     * Problem: Given a sorted array of unique integers and a target sum, find two numbers such that
     * they add up to the target. Return their 1-based indices.
     * <p>
     * Example 1:
     * Input: nums = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: nums[0] + nums[1] = 2 + 7 = 9
     * <p>
     * Example 2:
     * Input: nums = [1,3,4,5,7,10,11], target = 9
     * Output: [3,4]
     * <p>
     * Example 3:
     * Input: nums = [-5,-2,0,3,6,8,10], target = 4
     * Output: [3,5]
     * <p>
     * Example 4:
     * Input: nums = [1,2,3,4,5,6,7,8,9,10], target = 15
     * Output: [5,10]
     * <p>
     * Constraints:
     * - 2 <= nums.length <= 10^4
     * - -10^9 <= nums[i] <= 10^9
     * - nums is sorted in strictly increasing order.
     * - There is exactly one solution.
     */

    public static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1}; // Convert to 1-based index
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1}; // Should never be reached due to "exactly one solution" constraint
    }

    public static int[] twoSumOptimalSolution(int[] nums, int target) {
        int left = 0, right = nums.length - 1; // Alright, I can declare inline which looks cleaner.

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) return new int[]{left + 1, right + 1}; // Convert to 1-based index, comments for clarity
            if (sum < target) left++; // Increase sum by moving left pointer right
            else right--; // Decrease sum by moving right pointer left
        }

        return new int[]{-1, -1}; // Should never be reached due to "exactly one solution" constraint // Edge case in case there is no solution.
    }

    public static void run() {
        System.out.println("Running TwoSumSorted test cases...\n");

        // Test Case 1
        int[] test1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Input: " + Arrays.toString(test1) + ", Target: " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(test1, target1)) + "\n");

        // Test Case 2
        int[] test2 = {1, 3, 4, 5, 7, 10, 11};
        int target2 = 9;
        System.out.println("Input: " + Arrays.toString(test2) + ", Target: " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(test2, target2)) + "\n");

        // Test Case 3 (Includes negative numbers)
        int[] test3 = {-5, -2, 0, 3, 6, 8, 10};
        int target3 = 4;
        System.out.println("Input: " + Arrays.toString(test3) + ", Target: " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(test3, target3)) + "\n");

        // Test Case 4 (Longer array)
        int[] test4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target4 = 15;
        System.out.println("Input: " + Arrays.toString(test4) + ", Target: " + target4);
        System.out.println("Output: " + Arrays.toString(twoSum(test4, target4)) + "\n");

        // Test Case 5 (Larger numbers)
        int[] test5 = {10, 20, 30, 40, 50, 60};
        int target5 = 70;
        System.out.println("Input: " + Arrays.toString(test5) + ", Target: " + target5);
        System.out.println("Output: " + Arrays.toString(twoSum(test5, target5)) + "\n");
    }

    public static void main(String[] args) {
        run();
    }
}
