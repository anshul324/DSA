package arrays.hashmap_or_set;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashMap = new HashSet<>();
        for(int num : nums) {
            hashMap.add(num);
        }
        int maxCount = 0;
        for(int num : nums) {
            int count = 0;
            if(!hashMap.contains(num - 1)) {
                int i = 0;
                while(hashMap.contains(num + i)) {
                    ++count;
                    ++i;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
