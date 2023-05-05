package arrays;

import java.util.Arrays;

public class Kadane {
    public static int[] maxSubArrayFirst(int[] nums) {
        if(nums.length == 0) return nums;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;
        int i = 0;
        int j = 0;
        int last = j;
        while (i < n && j < n) {
            sum += nums[j];
            if(sum > max) {
                max = sum;
                last = j;
            }
            if(sum < 0) {
                sum = 0;
                ++i;
                j = i;
            } else {
                ++j;
            }
        }
        return Arrays.copyOfRange(nums, i, last + 1);
    }

    public static int maxSubArraySecond(int[] nums) {
        if(nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int a : nums) {
            sum += a;
            max = Math.max(max, sum);
            if(sum < 0) sum = 0;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArraySecond(arr));
        System.out.println(Arrays.toString(maxSubArrayFirst(arr)));
    }
}
