// https://leetcode.com/explore/interview/card/leetcodes-interview-crash-course-data-structures-and-algorithms/703/arraystrings/4836/
package Prefix;

import java.util.Arrays;

public class KRadiusSubarrayAverages {
    public static void main(String[] args) {
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        int k = 3;

        int[] nums1 = new int[]{100000};
        int k1 = 0;

        int[] nums2 = new int[]{8};
        int k2 = 100000;

        int[] output = getAverages(nums2, k2);
        System.out.println(Arrays.toString(output));
    }

    public static int[] getAverages(int[] nums, int k) {
        long[] prefixSum = new long[nums.length];
        prefixSum[0] = nums[0];

        int[] res = new int[nums.length];

        for(int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            var leftLimit = i < k;
            var rightLimit = i + k >= prefixSum.length;

            if(leftLimit || rightLimit){
                res[i] = -1;
                continue;
            }

            var L = i - k;
            var R = i + k;

            var sum = getValue(prefixSum, L, R);

            var average = getAverage(sum, k+k+1);

            res[i] = average;
            System.out.println(average);

        }
        System.out.println(res);
        return res;
    }

    public static long getValue(long[] prefixSum, int L, int R){
        if(L == 0) {
            return prefixSum[R];
        }
        return prefixSum[R] - prefixSum[L-1];
    }

    public static int getAverage(long value, int n){
        return (int) (value/n);
    }
}
