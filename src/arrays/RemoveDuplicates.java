package arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 1;
        while(i < nums.length) {
            if(nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                ++count;
            }
            ++i;
        }
        return count;
    }
}
