package arrays.n_sum;

import java.util.*;

public class ThreeSum {
    //TC: O(N^2*O(Insertion in Set))
    //SC: O(N)
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<List<Integer>> resultSet = new HashSet<>();
        for(int i = 0; i < nums.length; ++i) {
            for(int j = i + 1; j < nums.length; ++j) {
                if(!set.isEmpty() && set.contains(-(nums[i] + nums[j]))) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(-(nums[i] + nums[j]));
                    Collections.sort(temp);
                    resultSet.add(temp);
                }
                set.add(nums[j]);
            }
            set.clear();
        }
        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; ++i) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    ++j;
                    while(j < k && nums[j] == nums[j - 1]) ++j;
                } else if(sum < 0) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> res = threeSumOptimal(arr);
        System.out.println(res);
    }

}
