package arrays;

public class PowerXN {
    //https://leetcode.com/problems/powx-n/description/
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double pow = myPow(x, n / 2);
        return pow * pow * myPow(x, n % 2);
    }
}
