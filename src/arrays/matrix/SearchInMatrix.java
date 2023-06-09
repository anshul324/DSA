package arrays.matrix;

public class SearchInMatrix {
    //https://leetcode.com/problems/search-a-2d-matrix/
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high) {
            int mid = (low + high) / 2;
            int i = mid / n;
            int j = mid % n;
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                low = mid + 1;
            } else if(matrix[i][j] > target) {
                high = mid - 1;
            }
        }
        return false;
    }
}
