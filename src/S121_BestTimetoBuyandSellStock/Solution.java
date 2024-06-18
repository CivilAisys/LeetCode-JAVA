package S121_BestTimetoBuyandSellStock;

public class Solution {

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // 初始化最小價格為最大整數
        int maxProfit = 0; // 初始最大利潤為0

        // 遍歷每一天的價格
        for (int i = 0; i < prices.length; i++) {
            // 如果當前價格小於最小價格，更新最小價格
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // 否則計算當前價格與最小價格的差值，並更新最大利潤
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        // 返回最大利潤
        return maxProfit;
    }
}
