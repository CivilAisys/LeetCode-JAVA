package S120_Triangle;

import java.util.List;

public class Solution {
	// 使用dp 時間複雜度:O(n^2) 空間複雜度:O(n^2)
	public int minimumTotal(List<List<Integer>> triangle) {
		int n = triangle.size();
		// 初始化dp dp[i][j] 表示從 dp[0][0] 到 dp[i][j] 的最小路徑喝
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0); // 第一層只有一個值

		// 遍歷陣列 狀態轉移方程為 dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
		for(int i = 1; i < n; i++){
			for(int j = 0; j <= i;j++){
				int val = triangle.get(i).get(j);

				// 需要考慮最左最右的邊際情況
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + val;
				} else if (j == i) {
					dp[i][j] = dp[i - 1][j - 1] + val;
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + val;
				}
			}
		}

		// 找最後一層的最小值
		int minPathSum = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			minPathSum = Math.min(minPathSum, dp[n - 1][j]);
		}

		return minPathSum;
	}

	// 使用滾動陣列並使用bottom-up計算 來讓空間複雜度達到O(n)
	public int minimumTotal1(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[] dp = new int[n];

		// 初始化dp 從最後一層開始
		for (int j = 0; j < n; j++) {
			dp[j] = triangle.get(n - 1).get(j);
		}

		// 從倒數第二層開始向上更新dp陣列 狀態轉移方程為 dp[j] = min(dp[j],dp[j+1]) + currentVal
		for(int i = n-2; i >= 0;i--){
			for(int j = 0; j <= i; j++){
				dp[j] = Math.min(dp[j], dp[j+1]) +triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}
