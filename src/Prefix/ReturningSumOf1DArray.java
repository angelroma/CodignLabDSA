package Prefix;

// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4658/
//Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
//
//Return the running sum of nums.
//
//Example 1:
//
//Input: nums = [1,2,3,4]
//Output: [1,3,6,10]
//Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
//Example 2:
//
//Input: nums = [1,1,1,1,1]
//Output: [1,2,3,4,5]
//Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
//Example 3:
//
//Input: nums = [3,1,2,10,1]
//Output: [3,4,6,16,17]
//
//Constraints:
//
//        1 <= nums.length <= 1000
//        -10^6 <= nums[i] <= 10^6

public class ReturningSumOf1DArray {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};

        int[] output = runningSum(input);
        System.out.println(output);
    }

    public static int[] runningSum(int[] nums) {
        int[] computation = new int[nums.length];
        computation[0] = nums[0];
        for (var i = 1; i < nums.length; i++) {
            computation[i] = nums[i] + computation[i - 1];
        }
        return computation;
    }
}
