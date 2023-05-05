package arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i > 0) {
            if(nums[i] > nums[i - 1]) {
                break;
            }
            --i;
        }
        int nextGreater = i;
        int j = i + 1;
        while(j < nums.length && i > 0) {
            if(nums[j] > nums[i - 1] && nums[j] <= nums[nextGreater]) {
                nextGreater = j;
            }
            ++j;
        }
        if(i > 0) {
            swap(nums, i - 1, nextGreater);
            reverse(nums, i);
        } else {
            reverse(nums, 0);
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length-1;
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println();
        System.out.println();
    }
}
