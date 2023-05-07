package arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    //https://leetcode.com/problems/merge-intervals/
    public static int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[][] result = new int[intervals.length][];
        int j = 0;
        for (int[] interval : intervals) {
            int[] temp = new int[2];
            if (j > 0 && result[j - 1][1] >= interval[0]) {
                result[j - 1][1] = Math.max(interval[1], result[j - 1][1]);
            } else {
                temp[0] = interval[0];
                temp[1] = interval[1];
                result[j] = temp;
                ++j;
            }
        }
        int last = result.length;
        for(int i = 0; i < result.length; ++i) {
            if(result[i] == null) {
                last = i;
                break;
            }
        }
        return Arrays.copyOfRange(result, 0, last);
    }

    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8, 9}, {1, 10}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }

}
