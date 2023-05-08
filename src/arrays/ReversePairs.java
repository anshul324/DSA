package arrays;

import java.util.Arrays;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    int mergeSortAndCount(int[] nums, int left, int right) {
        if(left >= right) {
            return 0;
        }
        int count = 0;
        int mid = (left + right) / 2;
        count += mergeSortAndCount(nums, left, mid);
        count += mergeSortAndCount(nums, mid + 1, right);
        count += mergeAndCount(nums, left, mid, right);
        return count;
    }

    int mergeAndCount(int[] nums, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(nums, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(nums, mid + 1, right + 1);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < leftArray.length) {
            int c = 0;
            while(j < rightArray.length && leftArray[i] > 2 * (long)rightArray[j]) {
                ++j;
                ++c;
            }
            count += c * (leftArray.length - i);
            ++i;
        }
        i = 0;
        j = 0;
        while(i < leftArray.length && j < rightArray.length) {
            if(leftArray[i] <= rightArray[j]) {
                nums[left++] = leftArray[i++];
            } else {
                nums[left++] = rightArray[j++];
            }
        }
        while(i < leftArray.length) {
            nums[left++] = leftArray[i++];
        }
        while(j < rightArray.length) {
            nums[left++] = rightArray[j++];
        }
        return count;
    }
}
