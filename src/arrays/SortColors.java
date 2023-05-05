package arrays;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int a : nums) {
            count[a]++;
        }
        int k = 0;
        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < count[i]; ++j) {
                nums[k++] = i;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
