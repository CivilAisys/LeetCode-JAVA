package S122_BestTimetoBuyandSellStockII;

public class Solution {
	// 使用dp 每一天的最大利潤 只取決於前一天的狀態
	public int maxProfit(int[] prices) {
		int n = prices.length;
		int[][] dp = new int[n][2];

		// 初始狀態
		dp[0][0] = 0; // 第 0 天不持有股票的利潤
		dp[0][1] = -prices[0]; // 第 0 天持有股票，等於買入的成本

		for (int i = 1; i < n; i++) {
			// 最多持有一張股票
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]); // 前一天未持有 OR 前一天持有當天賣出
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]); // 前一天持有 OR 前一天未持有當天買入
		}

		return dp[n - 1][0]; // 最後一天不持有股票時的最大利潤
	}
}
