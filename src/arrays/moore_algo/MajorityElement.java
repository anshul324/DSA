package arrays.moore_algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            if(map.isEmpty() || !map.containsKey(num)) {
                map.put(num, 0);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for(Map.Entry<Integer, Integer> key : map.entrySet()) {
            if(key.getValue() > nums.length / 2) {
                return key.getKey();
            }
        }
        return 0;
    }

    public int findMajorityElementUsingMooreVotingAlgorithm(int[] nums) {
        int soldier = Integer.MIN_VALUE;
        int lives = 0;
        for(int num : nums) {
            if(lives == 0) {
                soldier = num;
                ++lives;
            } else {
                if(soldier == num) ++lives;
                else --lives;
            }
        }
        return soldier;
    }

    public List<Integer> majorityElementNby3(int[] nums) {
        //https://leetcode.com/problems/majority-element-ii/description/
        int soldier1 = Integer.MIN_VALUE;
        int soldier2 = Integer.MIN_VALUE;
        int lives1 = 0;
        int lives2 = 0;
        for(int num : nums) {
            if(lives1 == 0 && soldier2 != num) {
                soldier1 = num;
                lives1 = 1;
            } else if(lives2 == 0 && soldier1 != num) {
                soldier2 = num;
                lives2 = 1;
            } else if(soldier1 == num) {
                ++lives1;
            } else if(soldier2 == num) {
                ++lives2;
            } else {
                --lives1;
                --lives2;
            }
        }
        int countSoldier1 = 0;
        int countSoldier2 = 0;
        for(int num : nums) {
            if(soldier1 == num) {
                ++countSoldier1;
            } else if(soldier2 == num) {
                ++countSoldier2;
            }
        }
        List<Integer> result = new ArrayList<>();
        if(countSoldier1 > nums.length / 3) result.add(soldier1);
        if(countSoldier2 > nums.length / 3) result.add(soldier2);
        return result;
    }
}
