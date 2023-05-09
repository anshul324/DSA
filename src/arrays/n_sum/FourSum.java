package arrays.n_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; ++i) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 2; ++j) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = nums.length - 1;
                while(k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ++k;
                        while(k < l && nums[k] == nums[k - 1]) ++k;
                    } else if(sum > target) {
                        --l;
                    } else {
                        ++k;
                    }
                }
            }
        }
        return result;
    }
}
