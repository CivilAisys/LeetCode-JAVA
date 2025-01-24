package S64_MinimumPathSum;

public class Solution {

	/**
	 * 時間複雜度：O(m * n)
	 * 空間複雜度：O(m * n)
	 */
	public int minPathSum(int[][] grid) {
		// 初始化dp dp[i][j] 代表起點到達(i, j)所有可能中最小的和
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] dp = new int[rows][cols];
		dp[0][0] = grid[0][0];

		// 初始化第一行 第一列
		for (int row = 1; row < rows; row++) {
			dp[row][0] = dp[row - 1][0] + grid[row][0];
		}
		for (int col = 1; col < cols; col++) {
			dp[0][col] = dp[0][col - 1] + grid[0][col];
		}

		// 遍歷矩陣
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				dp[row][col] = Math.min(dp[row - 1][col] + grid[row][col], dp[row][col - 1] + grid[row][col]);
			}
		}

		return dp[rows - 1][cols - 1];
	}
}
