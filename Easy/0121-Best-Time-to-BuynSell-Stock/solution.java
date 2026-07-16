class Solution {
    public int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i]<lowestPrice) {
                lowestPrice = prices[i];
            } else {
                int profit = prices[i] - lowestPrice;
                if(profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
