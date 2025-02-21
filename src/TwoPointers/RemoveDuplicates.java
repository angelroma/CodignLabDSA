package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicates {
    /**
     * Problem: Given a sorted array, remove duplicates in-place such that each element appears only once.
     * Return the new length of the modified array.
     * <p>
     * Example 1:
     * Input: nums = [1, 1, 2]
     * Output: 2
     * Explanation: The first two elements are [1, 2], the rest are ignored.
     * <p>
     * Example 2:
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5
     * Explanation: The first five elements are [0,1,2,3,4], the rest are ignored.
     * <p>
     * Constraints:
     * - 1 <= nums.length <= 3 * 10^4
     * - -100 <= nums[i] <= 100
     * - nums is sorted in non-decreasing order.
     */
    public static int removeDuplicates(int[] nums) {
        // Implement two-pointer approach
        List<Integer> result = new ArrayList<>();

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            if (result.size() == 0) {
                result.add(nums[right]);
                right++;
            }

            if (result.get(left) == nums[right]) {
                right++;
            } else {
                left++;
                result.add(nums[right]);
            }
        }

        return result.size(); // Placeholder return
    }

    /**
     * Optimal Two-Pointer Approach - In-Place
     * <p>
     * Time Complexity: O(N) - Iterating through the array once.
     * Space Complexity: O(1) - Modifying the array in place without extra storage.
     */
    public static int removeDuplicatesOptimalSolution(int[] nums) {
        if (nums.length == 0) return 0;

        int left = 0; // Slow pointer

        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) { // Found a new unique element
                left++;
                nums[left] = nums[right]; // Move the new unique element to the front
            }
        }

        return left + 1; // Length of unique elements
    }

    public static void Main() {
        // Example: Test RemoveDuplicates
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result = RemoveDuplicates.removeDuplicatesOptimalSolution(nums);
        System.out.println("RemoveDuplicates result: " + result);
    }
}


