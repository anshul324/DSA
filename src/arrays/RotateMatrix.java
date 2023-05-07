package arrays;

public class RotateMatrix {
    //https://leetcode.com/problems/rotate-image/
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < n; ++i) {
            for(int j = i + 1; j < n; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int[] ints : matrix) {
            reverse(ints);
        }

    }

    void reverse(int[] arr) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            ++i;
            --j;
        }
    }
}
