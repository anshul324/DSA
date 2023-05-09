package arrays.maths_or_combination;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int N = n + m - 2;
        int r = Math.min(m - 1, n - 1);
        double res = 1;
        for(int i = 1; i <= r; i++){
            res = res * (N - r + i) / i;

        }
        return (int)res;

    }
}
