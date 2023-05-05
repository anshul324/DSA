package arrays;

import java.util.Arrays;

public class BuyAndSellStocks1 {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for(int i = 1; i < prices.length; ++i) {
            maxProfit = Math.max(maxProfit, prices[i] - buyPrice);
            if(prices[i] < buyPrice) {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
