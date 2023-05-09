package arrays.maths_or_combination;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalResult = new ArrayList<>();
        for(int k = 0; k < numRows; ++k) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for(int i = 1; i < k; ++i) {
                list.add(pascalResult.get(k - 1).get(i - 1) + pascalResult.get(k - 1).get(i));
            }
            if(k > 0)
                list.add(1);
            pascalResult.add(list);
        }
        return pascalResult;
    }
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println();
        System.out.println();
    }
}
