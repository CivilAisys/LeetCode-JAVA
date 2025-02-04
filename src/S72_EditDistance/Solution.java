package S72_EditDistance;

public class Solution {

	/**
	 * 使用DP  狀態定義將 word1[0:i]（前 i 個字元）轉換成 word2[0:j]（前 j 個字元）所需的最少操作數 i j 表示的為長度 非索引
	 */
	public int minDistance(String word1, String word2) {
		int m = word1.length(), n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		// 初始化邊界條件
		for (int i = 0; i <= m; i++) {
			dp[i][0] = i; // 將word1[0:i] 變為空字串需要刪除i次
		}
		for (int j = 0; j <= n; j++) {
			dp[0][j] = j; // // 空字串轉換為 word2[0:j]，需插入 j 次
		}

		// 動態規劃填表
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1]; // 相等時，繼承 dp[i-1][j-1] 最後一個字元相同  直接繼承
				} else {
					// 不相同情況下
					dp[i][j] = Math.min(dp[i - 1][j],   // 刪除
						Math.min(dp[i][j - 1], // 插入
							dp[i - 1][j - 1]) // 替換
					) + 1;
				}
			}
		}

		return dp[m][n];
	}
}
