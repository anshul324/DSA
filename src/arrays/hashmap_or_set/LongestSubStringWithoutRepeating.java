package arrays.hashmap_or_set;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeating {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        int i = 0;
        int j = 1;
        int result = 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);
        while (j < s.length()) {
            while (j < s.length() && (map.isEmpty() || !map.containsKey(s.charAt(j)) || map.get(s.charAt(j)) < i)) {
                map.put(s.charAt(j), j);
                ++j;
            }
            result = Math.max(result, j - i);
            if(j < s.length()) {
                i = map.get(s.charAt(j)) + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        int res = lengthOfLongestSubstring(s);
        System.out.println(res);
    }
}
