package S322_CoinChange;

import java.util.Arrays;

public class Solution {

	public int coinChange(int[] coins, int amount) {
		// 初始化dp陣列 長度為amount + 1 dp[i] 表示達成金額i所需最少硬幣數
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1); // 使用不可能的金額填充其他值
		dp[0] = 0;

		// 計算dp
		for (int i = 1; i <= amount; i++) {
			for (int coin : coins) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], dp[i - coin] + 1);
				}
			}
		}
		// 若dp[amount] 保持初始值 代表無法湊成該金額
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
