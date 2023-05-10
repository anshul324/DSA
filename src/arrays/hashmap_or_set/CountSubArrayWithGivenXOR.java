package arrays.hashmap_or_set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrayWithGivenXOR {
    public static int subarraysXor(ArrayList<Integer> arr, int k) {
        // Write your code here.
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int xr = 0;
        int result = 0;
        for(Integer a : arr) {
            xr = xr ^ a;
            if(xr == k) result++;
            int xrk = xr ^ k;
            if(prefixMap.containsKey(xrk)) {
                result += prefixMap.get(xrk);
            }
            if(prefixMap.containsKey(xr)) {
                prefixMap.put(xr, prefixMap.get(xr) + 1);
            } else {
                prefixMap.put(xr, 1);
            }
        }
        return result;
    }
}
