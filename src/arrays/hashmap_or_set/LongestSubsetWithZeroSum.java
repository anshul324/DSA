package arrays.hashmap_or_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsetWithZeroSum {
    public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
        // Write your code here.
        int[] prefixSum = new int[arr.size()];
        prefixSum[0] = arr.get(0);
        for(int i = 1; i < arr.size(); ++i) {
            prefixSum[i] = prefixSum[i - 1] + arr.get(i);
        }
        if(prefixSum[prefixSum.length - 1] == 0) return prefixSum.length;
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < prefixSum.length; ++i) {
            if(prefixSum[i] == 0) result = i + 1;
            else if(!map.isEmpty() && map.containsKey(prefixSum[i])) {
                result = Math.max(result, i - map.get(prefixSum[i]));
            } else
                map.put(prefixSum[i], i);
        }
        return result;
    }
}
