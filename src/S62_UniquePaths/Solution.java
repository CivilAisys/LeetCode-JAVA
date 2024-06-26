package S62_UniquePaths;

public class Solution {

    /**
     * 使用dp
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // 初始化dp數組 dp[i][j] 代表起點到 (i ,j)不同的路徑數

        //初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        // 填充dp 狀態轉移 只能從上或左到達下一個點
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j]; //狀態轉移
            }
        }

        return dp[m - 1][n - 1];
    }
}
