package Prefix;

public class NumberofWaystoSplitArray {
    public static void main(String[] args) {
        // ✅ Load the large array dynamically
        int[] nums = LargeArray.loadArray();

        if (nums.length == 0) {
            System.out.println("Failed to load the array.");
            return;
        }

        // ✅ Compute and print the number of valid splits
        System.out.println("Valid Splits: " + waysToSplitArray(nums));
    }

    public static int waysToSplitArray(int[] nums) {
        int count = 0;
        int[] prefixSum = new int[nums.length + 1];

        // Compute prefix sum
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // Check valid splits
        for (int i = 0; i < nums.length - 1; i++) {
            int first = sum(prefixSum, 0, i);
            int second = sum(prefixSum, i + 1, nums.length - 1);
            if (first >= second) count++;
        }

        return count;
    }

    public static int sum(int[] prefixSum, int L, int R) {
        return prefixSum[R + 1] - prefixSum[L]; // Simplified sum calculation
    }
}
