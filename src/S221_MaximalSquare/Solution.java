package S221_MaximalSquare;

public class Solution {

	// 使用dp
	public int maximalSquare(char[][] matrix) {
		// 獲取行列
		int rows = matrix.length;
		int cols = matrix[0].length;

		// 創建dp數組 +1來處理可能的邊界條件 dp儲存的是每個位置做為右下角的最大正方形邊長
		int[][] dp = new int[rows + 1][cols + 1];
		int maxSide = 0;

		// 遍每個位置 從 (1,1)開始 (0,y) (x,0) 是多出來用來處理邊界的
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				// 右下角為 '1' 才有可能組成更大的正方形
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					maxSide = Math.max(dp[i][j], maxSide);
				}
			}
		}

		return maxSide * maxSide;
	}

}
