package S63_UniquePathsII;

public class Solution {

	/**
	 * 時間複雜度：O(m*n)
	 * 空間複雜度：O(m*n)
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		// 如果起點為障礙 代表後續都不可能
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}

		// 初始化dp dp[i][j] 代表起點到達(i, j) 所可能的組合
		int rows = obstacleGrid.length;
		int cols = obstacleGrid[0].length;
		int[][] dp = new int[rows][cols];

		// 初始化第一列及第一行  若有障礙 那後續都不可能到達
		for (int row = 0; row < rows; row++) {
			if (obstacleGrid[row][0] == 1) {
				break;
			}
			dp[row][0] = 1;
		}
		for (int col = 0; col < cols; col++) {
			if (obstacleGrid[0][col] == 1) {
				break;
			}
			dp[0][col] = 1;
		}

		// 遍歷矩陣 左排上排不需遍歷
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				// 沒有障礙才能進行狀態轉移
				if (obstacleGrid[row][col] == 0) {
					dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
				}
			}
		}

		return dp[rows - 1][cols - 1];
	}
}
