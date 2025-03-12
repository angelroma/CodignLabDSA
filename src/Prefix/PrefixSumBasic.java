package Prefix;

public class PrefixSumBasic {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[] prefixSum = new int[nums.length + 1];

        // Compute prefix sum
        for (int i = 1; i <= nums.length; i++) {
            int num = nums[i - 1];
            int prevNum = prefixSum[i - 1];
            prefixSum[i] = prevNum + num;
        }

        // Example queries
        System.out.println(getRangeSum(prefixSum, 0, 3)); // Output: 12
        System.out.println(getRangeSum(prefixSum, 2, 5)); // Output: 14
        System.out.println(getRangeSum(prefixSum, 2, 4)); // Output: 12
    }

    public static int getRangeSum(int[] prefixSum, int L, int R) {
        return prefixSum[R + 1] - prefixSum[L];
    }
}
